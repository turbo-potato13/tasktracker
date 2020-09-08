-- CREATE TABLE user (
-- id bigserial PRIMARY KEY
--
-- );
DROP TABLE if EXISTS task CASCADE;
CREATE TABLE task(
    id bigserial PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(5000),
--     constraint fk_user_id foreign key (user_id) references user (id),
    status VARCHAR(255),
    priority VARCHAR(255),
    created_at TIMESTAMP DEFAULT current_timestamp,
    period_of_execution TIMESTAMP
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

