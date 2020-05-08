-- INSERT INTO TODO (name, content, isopen, category) VALUES
--   ('Todo1', 'Todo1 Content', TRUE, 'sport'),
--   ('Todo2', 'Todo2 Content', TRUE, 'dev'),
--   ('Todo3', 'Todo3 Content', TRUE, 'sport'),
--   ('Todo4', 'Todo4 Content', TRUE, 'sport'),
--   ('Todo5', 'Todo5 Content', FALSE, 'dev');



insert into USER (username, password, enabled, role) values ('user1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');
insert into USER (username, password, enabled, role) values ('user2', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER'); 

insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo1', 'description1', 'sport', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo2', 'description2', 'it', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo3', 'description3', 'sport', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
insert into TODO (title, description, category, status, created_at, updated_at, user_id) values ('todo4', 'description4', 'it', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);




-- insert into TODO (title, description, status, created_at, updated_at) values ('todo1', 'description1', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo2', 'description2', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo3', 'description3', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
-- insert into TODO (title, description, status, created_at, updated_at) values ('todo4', 'description4', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());