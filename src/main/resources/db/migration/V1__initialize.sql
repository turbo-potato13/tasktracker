
DROP TABLE if EXISTS task CASCADE;
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
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
    period_of_execution TIMESTAMP
    project_id BIGINT,
    constraint fk_project_id foreign key (project_id) references projects(id)
    );
INSERT INTO task (name, description, status, priority) VALUES
('Task', 'description1', 'BACKLOG', 'LOW');
-- ('Task', 'description1', 'BACKLOG', 'LOW');

-- DROP TABLE if EXISTS comment CASCADE;
-- CREATE TABLE comment(
--     id bigserial PRIMARY KEY,
--     content VARCHAR(5000),
--     task_id bigint not null,
--     foreign key (task_id) references task (id)
-- );

