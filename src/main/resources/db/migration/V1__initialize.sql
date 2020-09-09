DROP TABLE if EXISTS task CASCADE;
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

CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    manager_user_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE projects_users (
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT REFERENCES projects(id) ON DELETE CASCADE,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE task(
    id bigserial PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(5000),
--     constraint fk_user_id foreign key (user_id) references user (id),
    status VARCHAR(255),
    priority VARCHAR(255),
    created_at TIMESTAMP DEFAULT current_timestamp,
    period_of_execution TIMESTAMP,
    comment VARCHAR(5000),
    project_id BIGINT,
    constraint fk_project_id foreign key (project_id) references projects(id)
);
INSERT INTO task (name, description, status, priority, comment) VALUES
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

create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       created_at            timestamp default current_timestamp,
                       updated_at            timestamp default current_timestamp,
                       primary key (id)
);

CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);


DROP TABLE if EXISTS comment CASCADE;
CREATE TABLE comment(
    id bigserial PRIMARY KEY,
    content VARCHAR(5000),
    task_id bigint not null,
    foreign key (task_id) references task (id)
);




