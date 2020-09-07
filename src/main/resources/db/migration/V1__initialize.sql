CREATE TABLE task(
    id bigserial PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(5000),
--     constraint fk_user_id foreign key (user_id) references user (id),
    status VARCHAR(255),
    priority VARCHAR(255),
    created_at TIMESTAMP DEFAULT current_timestamp,
    period_of_execution TIMESTAMP,
    comment VARCHAR(5000)
    );
INSERT INTO task (name, description, status, priority, comment) VALUES
('Task', 'description1', 'BACKLOG', 'LOW', 'Comment'),
('Task', 'description1', 'BACKLOG', 'LOW', 'Comment');

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
)

CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,
    title TEXT,
    user_manager_id BIGINT REFERENCES users(id),
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
)

CREATE TABLE projects_users (
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT REFERENCES projects(id),
    user_id BIGINT REFERENCES users(id),
)

