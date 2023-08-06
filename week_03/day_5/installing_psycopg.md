# The psycopg2 Library

We now want to be able to get our Python code to communicate with our database. We are going to use a library to help us with this. This library will handle connecting to the database and will execute SQL for us.

We are using a PostgreSQL database so we need to use a library which has been written with this in mind. There are several libraries we could use but we are going to a library called [psycopg2](https://pypi.org/project/psycopg2/), which is the most popular. 

The psycopg2 library is not installed automatically when we install python so we need to install it. Can you remember which program we use to install Python libraries and packages? `pip3`.

So let's install psycopg2

```bash
# terminal

pip3 install psycopg2
```