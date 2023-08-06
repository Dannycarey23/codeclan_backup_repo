# Lab + Homework

Given the basic code for classes and JpaRepositories for a whisky tracker, your task for this lab is to complete the custom queries and connected them to appropriate RESTful endpoints.

## Making sure the database is clean and ready to use

Open Postico go to the database whiskies (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb whiskies``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: If you had to change the username by which you connect to the database in the previous lessons you will need to change it again in the application.properties under the main->resources folder.

**Whisky**

- `name` - the name of that individual whisky often uses the name of the distillery. An example is "The Glendronach - Revival" which is from "Glendronach" distillery
- `distillery` - the distillery object that it's related to
- `year` - the year edition that the whisky was released/ bottled. The year is not a way of determining the age.
- `age` - how long the whisky in the bottle was matured for before bottling

**Distillery**

- `name` - The name of the whisky distillery.
- `region` - The region of scotland where the whisky is from. These are one of either {**Lowlands**, **Speyside**, **Highlands**, **Islay**, **Campbelltown**, **Island** }
- `whiskys` - the list of related whiskies tracked against that distillery

## Task

**Custom Queries + REST** Write each of the following queries and connect them to an appropriate controller:

### MVP
  * Get all the whiskies for a particular year
  * Get all the distilleries for a particular region
  * Get all the whisky from a particular distillery that's a specific age
  
###  Extensions
  * Get all the whisky from a particular region 
  * Get distilleries that have whiskies that are 12 years old 



## Tips
* To stop your custom routes recursively referencing each other's properties, you will need a `@JsonIgnoreProperties("some_property_you_need_to_ignore")` annotation on related properties.


