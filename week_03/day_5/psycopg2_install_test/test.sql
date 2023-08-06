DROP TABLE IF EXISTS tests;

CREATE TABLE tests (
  id SERIAL PRIMARY KEY,  
  name VARCHAR(255)
);

INSERT INTO tests (name) VALUES ('John');
INSERT INTO tests (name) VALUES ('Paul');
INSERT INTO tests (name) VALUES ('George');
INSERT INTO tests (name) VALUES ('Ringo');