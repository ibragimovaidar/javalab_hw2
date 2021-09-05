CREATE TABLE password_black_list (
    id SERIAL,
    password VARCHAR(64) UNIQUE,
    PRIMARY KEY(id)
);