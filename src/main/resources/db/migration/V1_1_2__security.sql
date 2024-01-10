CREATE TABLE if not exists users
(
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT authorities_idx UNIQUE (username, authority)
--     CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities VALUES
('admin', 'ROLE_ADMIN'),
('user', 'ROLE_USER');
