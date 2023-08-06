This tests to see if `psycopg2` is working with PSQL.

It can be run after installing `psycopg2`. To run:

`sh test.sh`

It should do the following:

*  Create a psql database `test_db`
*  Run the `test.sql` file on the created database. This file creates a table and fills it with some data
* It should the run the `test.py` file which queries the data in the table. If successful, it should print the following:

```
1 - John
2 - Paul
3 - George
4 - Ringo
```

* Finally, it drops the database created.