-- INSERT INTO TODO (name, content, isopen, category) VALUES
--   ('Todo1', 'Todo1 Content', TRUE, 'sport'),
--   ('Todo2', 'Todo2 Content', TRUE, 'dev'),
--   ('Todo3', 'Todo3 Content', TRUE, 'sport'),
--   ('Todo4', 'Todo4 Content', TRUE, 'sport'),
--   ('Todo5', 'Todo5 Content', FALSE, 'dev');




insert into USER (username, password, enabled, role) values ('yasoo', '$2a$10$xTf63ne7IxYMzn7FSDDuD..jMOVaDXG3UdFw3c59Lz0bk8rAX4iO6', true, 'ROLE_ADMIN'); 
insert into USER (username, password, enabled, role) values ('admin', '$2a$10$LiTqnSHezbNJCUMdI9k4QeYYw4G2hmHuidkkEuimKTNIE7fMryCnu', true, 'ROLE_ADMIN'); 

insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo1', 'description1', 'JAVA', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo2', 'description2', 'WEB', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo3', 'description3', 'JAVA', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo4', 'description4', 'ANGULAR', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);


insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo99987', 'description19989', 'JAVA', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo9897', 'description2989', 'WEB', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo99987', 'description19989', 'JAVA', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo9897', 'description2989', 'WEB', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo99987', 'description19989', 'JAVA', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);






-- insert into TODO (title, description, status, created_at, updated_at) values ('todo1', 'description1', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo2', 'description2', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo3', 'description3', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo4', 'description4', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());