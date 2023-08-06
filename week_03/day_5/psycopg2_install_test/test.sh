#!/bin/sh

createdb test_db

psql -d test_db -f test.sql

python3 test.py

dropdb test_db