# Lab: Bootstrap an Employee tracking application

**Lab Duration: 45-60 minutes**

### Learning Objectives

- Consolidate how to bootstrap a new Spring Application
- Be able to annotate a class for persistence to the database
- Be able to create a repository for doing database operations
- Be able to inject the repository into the controller

## Brief

In this lab please use what you've already learned about Spring to create an entirely new Spring application that allows you to get the details of an employee.

Start from scratch using the [ Spring Boot Initializr](https://start.spring.io/).

### MVP

Create a Spring Boot application for recording employee data that has:
- An Employee class that conforms to POJO and is annotated with fields `name`, `age`, `employeeNumber` and `email`.
- A repostory for doing database operations
- A RestController with one route for getting a JSON list of all Employees.

## Planning

Make a list/diagram of the files that will make up your program and note down their responsibilities.

### Making sure the database is clean and ready to use

Open Postico go to the database employees (if it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb employees``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.
