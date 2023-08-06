# SQL Lab Answers

1) Return ALL the data in the 'movies' table.

```sql
SELECT * FROM movies;
```

2) Return ONLY the name column from the 'people' table

```sql
SELECT name FROM people;
```

3) Oops! Someone spelled Krusty The Clown's name wrong! Change it to reflect the proper spelling (Crusty should be Krusty).

```sql
UPDATE people SET name = 'Krusty the Clown' WHERE id = 13;
```

4) Return ONLY Homer Simpson's name from the 'people' table.

```sql
SELECT name FROM people WHERE id = 1;
```

5) The cinema is showing 'Batman Begins', but Batman is DC, not Marvel! Delete the entry from the 'movies' table.

```sql
DELETE FROM movies WHERE title = 'Batman Begins';
```

6) We forgot one of the main characters! Add Bart Simpson to the 'people' table

```sql
INSERT INTO people (name) VALUES ('Bart Simpson');
```

7) Eric Cartman has decided to hijack our movie evening, Remove him from the table of people.

```sql
DELETE FROM people WHERE name = 'Eric Cartman';
```

8) The cinema has just heard that they will be holding an exclusive midnight showing of 'Guardians of the Galaxy 2'!! Create a new entry in the 'movies' table to reflect this.

```sql
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Infinity War', 2018, '00:00');
```

9) The cinema would like to make the Iron Man movies a triple billing. Find out the show time of "Iron Man 2" and set the show time of "Iron Man 3" to start two hours later.

```sql
SELECT show_time FROM movies WHERE title = 'Iron Man 2';
UPDATE movies SET show_time = '20:45' WHERE title = 'Iron Man 3';
```

## Extension

1) Research how to delete multiple entries from your table in a single command.

```sql
DELETE FROM table WHERE name='' OR name='';
```
