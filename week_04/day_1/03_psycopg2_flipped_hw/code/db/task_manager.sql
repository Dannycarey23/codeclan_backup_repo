DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  description VARCHAR(255),
  assignee VARCHAR(255),
  duration INT,
  completed BOOLEAN DEFAULT FALSE
);

INSERT INTO tasks (description, assignee, duration) 
VALUES ('Walk Dog', 'Jack Jarvia', 60);

INSERT INTO tasks (description, assignee, duration) 
VALUES ('Feed Cat', 'Victor McDade', 5);