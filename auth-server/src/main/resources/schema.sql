DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users_departments;
DROP TABLE IF EXISTS departments;

CREATE  TABLE users (
  user_name VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled boolean NOT NULL ,
  PRIMARY KEY (user_name));

CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_name         VARCHAR(100) NOT NULL,
  role              VARCHAR(100) NOT NULL,
  PRIMARY KEY (user_role_id));
