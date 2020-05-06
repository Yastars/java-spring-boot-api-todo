package hue.elte.web.practice.ToDo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import hue.elte.web.practice.ToDo.entity.UserEntity;
import hue.elte.web.practice.ToDo.repository.UserRepository;

@Controller
public class AuthController {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String registerForm() {
    return "register";
  }

  @PostMapping("/register")
  public String register(UserEntity userEntity, Model model) {
    Optional<UserEntity> oUser = userRepository.findByUsername(userEntity.getUsername());
    if (oUser.isPresent()) {
      model.addAttribute("error", "Existing user name");
      return "register";
    }
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    userEntity.setEnabled(true);
    userEntity.setRole(UserEntity.Role.ROLE_USER);
    userRepository.save(userEntity);
    return "redirect:/login";
  }
}