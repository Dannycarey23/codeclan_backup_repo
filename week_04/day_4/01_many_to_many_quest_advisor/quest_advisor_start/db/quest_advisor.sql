DROP TABLE users;
DROP TABLE locations;

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE locations (
  id SERIAL PRIMARY KEY,
  category VARCHAR(255),
  name VARCHAR(255)
);
