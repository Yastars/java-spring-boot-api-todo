package hue.elte.web.practice.ToDo.configuration;



import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hue.elte.web.practice.ToDo.entity.UserEntity;
import hue.elte.web.practice.ToDo.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private AuthenticatedUser authenticatedUser;

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserEntity> oUser = userRepository.findByUsername(username);
    if (!oUser.isPresent()) {
      throw new UsernameNotFoundException(username);
    }
    UserEntity user = oUser.get();
    authenticatedUser.setUser(user);
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}