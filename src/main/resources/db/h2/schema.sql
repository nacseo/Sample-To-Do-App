CREATE TABLE IF NOT EXISTS TODO (
    todo_id bigint NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    todo_order int NOT NULL,
    completed boolean NOT NULL,
    PRIMARY KEY (todo_id)
);