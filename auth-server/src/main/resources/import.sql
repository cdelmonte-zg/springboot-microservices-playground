INSERT INTO users(user_name,password,enabled) VALUES ('johnny.mnemonic','$2a$09$Bf/uBfdezC6xEsjSK7ub0.YHUCZM8lUkkG2.NPFdDCbV.YT2thgKS', true);
INSERT INTO users(user_name,password,enabled) VALUES ('william.gibson','$2a$09$Bf/uBfdezC6xEsjSK7ub0.YHUCZM8lUkkG2.NPFdDCbV.YT2thgKS', true);

INSERT INTO user_roles (user_name, role) VALUES ('johnny.mnemonic', 'ROLE_USER');
INSERT INTO user_roles (user_name, role) VALUES ('william.gibson', 'ROLE_ADMIN');
INSERT INTO user_roles (user_name, role) VALUES ('william.gibson', 'ROLE_USER');
