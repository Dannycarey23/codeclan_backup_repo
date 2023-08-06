-- End code after one-to-many lesson
DROP TABLE lightsabers;
DROP TABLE characters;

CREATE TABLE characters (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  darkside BOOLEAN,
  age INT
);

CREATE TABLE lightsabers (
  id SERIAL PRIMARY KEY,
  character_id INT REFERENCES characters(id),
  hilt_metal VARCHAR(255),
  colour VARCHAR(255)
);

INSERT INTO characters (name, darkside, age) VALUES ('Obi-Wan Kenobi', false,  27);
INSERT INTO characters (name, darkside, age) VALUES ('Anakin Skywalker', false, 19);
INSERT INTO characters (name, darkside, age) VALUES ('Darth Maul', true, 32);

INSERT INTO characters (name, darkside) VALUES ('Yoda', false);

UPDATE characters SET (name, darkside) = ('Darth Vader', true) WHERE name = 'Anakin Skywalker';

DELETE FROM characters WHERE name = 'Darth Maul';

INSERT INTO characters (name, darkside, age) VALUES ('Stormtrooper', true, 25);
INSERT INTO characters (name, darkside, age) VALUES ('Stormtrooper', true, 25);
INSERT INTO characters (name, darkside, age) VALUES ('Stormtrooper', true, 25);
INSERT INTO characters (name, darkside, age) VALUES ('Stormtrooper', true, 25);
INSERT INTO characters (name, darkside, age) VALUES ('Stormtrooper', true, 25);

SELECT * FROM characters;

INSERT INTO lightsabers (colour, character_id, hilt_metal) VALUES ('green', 1, 'palladium');
INSERT INTO lightsabers (colour, character_id, hilt_metal) VALUES ('red', 2, 'gold');

SELECT * FROM lightsabers;

INSERT INTO lightsabers (colour, character_id, hilt_metal) VALUES ('red', 2, 'titanium');

SELECT * FROM lightsabers WHERE character_id = 2;
