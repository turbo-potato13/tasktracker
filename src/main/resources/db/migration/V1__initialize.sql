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

CREATE TABLE projects
(
    id              BIGSERIAL PRIMARY KEY,
    title           TEXT   NOT NULL,
    manager_user_id BIGINT REFERENCES users (id) ON DELETE SET NULL,
    created_at      TIMESTAMP DEFAULT current_timestamp,
    updated_at      TIMESTAMP DEFAULT current_timestamp
);

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
    comment             VARCHAR(5000),
    project_id          BIGINT REFERENCES projects (id)
);

CREATE TABLE projects_users
(
    id         BIGSERIAL PRIMARY KEY,
    project_id BIGINT REFERENCES projects (id) ON DELETE CASCADE,
    user_id    BIGINT REFERENCES users (id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);


INSERT INTO task
    (name, description, status, priority, comment)
    VALUES
        ('Task', 'description1', 'BACKLOG', 'LOW', 'Comment'),
        ('Task', 'description1', 'BACKLOG', 'LOW', 'Comment');

CREATE TABLE roles
(
    id         SERIAL,
    name       VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp,
    PRIMARY KEY (id)
);
INSERT INTO roles
    (name)
    VALUES
        ('ROLE_USER'),
        ('ROLE_ADMIN'),
        ('DELETE_USERS_PERMISSION');

CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id INT    NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE comment
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255),
    description         VARCHAR(5000),
--     constraint fk_user_id foreign key (user_id) references user (id),
    status              VARCHAR(255),
    priority            VARCHAR(255),
    created_at          TIMESTAMP DEFAULT current_timestamp,
    period_of_execution TIMESTAMP,
    project_id          BIGINT REFERENCES projects (id)
);
INSERT INTO task
    (name, description, status, priority)
    VALUES
        ('Task', 'description1', 'BACKLOG', 'LOW'),
        ('Taeeeesk', 'descriprerereeretion1', 'BACKLOG', 'LOW');

DROP TABLE IF EXISTS comment CASCADE;
CREATE TABLE comment
(
    id         BIGSERIAL PRIMARY KEY,
    content    VARCHAR(5000),
    created_at TIMESTAMP DEFAULT current_timestamp,
    task_id    BIGINT NOT NULL,
    FOREIGN KEY (task_id) REFERENCES task (id)
);
INSERT INTO comment
    (content, task_id)
    VALUES
        ('commment', 1);

