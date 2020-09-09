CREATE TABLE task
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255),
    description         VARCHAR(5000),
--     constraint fk_user_id foreign key (user_id) references user (id),
    status              VARCHAR(255),
    priority            VARCHAR(255),
    created_at          TIMESTAMP DEFAULT current_timestamp,
    period_of_execution TIMESTAMP,
    comment             VARCHAR(5000)
);
INSERT INTO task
    (name, description, status, priority, comment)
    VALUES
        ('Task', 'description1', 'BACKLOG', 'LOW', 'Comment'),
        ('Task', 'description1', 'BACKLOG', 'LOW', 'Comment');

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    role       VARCHAR(255),
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);
