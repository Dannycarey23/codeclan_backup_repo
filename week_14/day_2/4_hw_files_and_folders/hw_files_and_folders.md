# Homework: Annotating One-to-Many and Many-to-One Relationships

### Learning Objectives


- Understand one to many relationships
- Be able to use Spring to create the RESTful routes for a set of resources
- Use Insomnia to test routes

## Making sure the database is clean and ready to use

Open Postico go to the database files_and_folders (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb files_and_folders``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: You may have to change the username in your application.properties file if your database username for Postgres is different to the default user specified in the application.properties.

This file is in main->resources

## Brief

Create a one-to-many Spring application using annotations as you've done before.

 Your application should have the following models: `Folders`, `Files` and `Persons`. Persons should have many folders, and folders should have many files.

You'll need to create repositories for each entity.

You'll need to create controllers for each entity, too, and ensure they implement the **index**, **create** and **show** routes.

### MVP

- Create a system to track files and folders:
  - A `File` should have:
     - a name
     - extension (e.g. txt, rb, java, ppt)
     - size
     - folder
  - A `Person` should have:
     - name
     - a list of folders
  - A `Folder` should have:
     - a title
     - list of files
     - a person
     
- Create a seeding file `DataLoader` component to pre-seed the database.
- Test the routes with Insomnia

## Planning

Draw a diagram detail the relationships between models.

