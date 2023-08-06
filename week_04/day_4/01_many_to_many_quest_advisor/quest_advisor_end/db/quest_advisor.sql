DROP TABLE visits;
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

CREATE TABLE visits (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  location_id INT NOT NULL REFERENCES locations(id) ON DELETE CASCADE,
  review TEXT
);
