# Simple JPA Queries

**Lesson Duration: 60 minutes**

### Learning Objectives
- Understand and use the power and simplicity of Spring Data JPA Derived Query Methods

# Introduction
**Why are we learning this?** Relational databases are great for storing data and preserving its structure. Quite often, when trying to get data we rely on that structure.

For example. We might say *"I've got this object, 'Shop'. Give me all of the 'Product' items in the shop"*

This type of query is extremely *relational* in that we are relying on the relationship to get the wanted data.

## Making sure the database is clean and ready to use

Open Postico go to the database pirates (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb pirates``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: If you had to change the username by which you connect to the database in the previous lessons you will need to change it again in the application.properties under the main->resources folder.

## Some things to think about
> This is just to get the right mindset and can be skipped if desired.



### Know what data you already have

When doing any sort of query, whether it be with or without Spring or Hibernate - one thing is always true.
**You always have some data to get started**.

Consider the following examples in SQL:

* `SELECT * from pirates;`, data we have is that we know to query `pirates` table.
* `SELECT * from pirates WHERE name ='Long John';` we have the `name` and that we're querying the pirates table
* `SELECT * from pirates WHERE name ='Jack' AND age = 30`. We have `name` and `age`, as well as that we are querying the `pirates` table.

Knowing that there's always a start point will help us construct queries easier.

Our start point is that we have a `Ship` meaning we can build a query method that takes a `Ship`. We can move forward knowing our query needs to take a `Ship`.




###  Know what data you want back

It may seem obvious, but knowing exactly what you want is extremely important. Some things to consider when figuring out what you want that will make things easier:

- Do you want a List of a particular object?
- Do you want just **one** of a partular object?
- Do you want a primitive or reference type back - such as an int, String or Boolean?




The question on whether we want a scalar (just one of an object) or a vector (a list) **depends on the uniqueness involved in the query**.

#### Uniqueness
Uniqueness of a queriy depends on whether a unique id like the `id` property of a model was used to construct the query or if some non-unique properites are being used to build it like "first name", "last name", "age", "date of birth". These kinds of things are properties which potentially many could share.

##### Unique
When building a query with known unique identifiers like the id, or some other known key we then also know that there will only be one value, rather than a list of values, returned.


##### Non-unique

When building a query with non-unique properites, then it's best to save the results of the query as a list.

<a name="build_query"></a>
### Build the Derived Query

Lets put together a query for getting all the `Pirate`s over a given age.

Since we're getting **all** the `Pirate`s over an age, it's a `List` of `Pirate` we want back. This is very much a non-unique query result. The method should therefore return a `List<Pirate>`.

We now know we:

* Want to find a `List<Pirate>`
* Want to give it a number, the age.


In English, we can say:

* `"Find all Pirates over age X"`



*Derived Queries* are where we write the method **prototype** for a query we want to run, and Spring tries to derive the query from how that method prototype is structured.


The prototype needs to match a certain pattern. That pattern needs to match one of `find..By..`, `read..By..`, `count..By..`, `get..By..`.

So, the general structure of these methods needs to match:

**operation**<**object**>By<**property**><**operator**>
where:

*  **operation** is one of `find`, `read`, `count`, `get`.
*  **object** is the type of object you expect back from the query. 
*  **property** is a property on the **object**
*  **operator** is one of `And`, `Or`.

-------
 

**Some unrelated examples** (can skip to **for our query** if desired)

 If we wish to get all pirates by a specific age, then we would write:

```java
List<Pirate> findPiratesByAge(int age);
```
Find a Pirate by name:

```java
List<Pirate> findPiratesByName(String name);
```

Find a Pirate by name, but give only one result (notice use of `Distinct`):

```java
Pirate findDistinctPiratesByName(String name);
```

Find people by first name **or** last name:

```java
List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
```

----

**For our query** `"Find all Pirates over a given age"`, we will add the following to `PirateRepository.java`:

```java
//PirateRepository.java
public interface PirateRepository extends JpaRepository<Pirate, Long> { // AS BEFORE
    
    List<Pirate> findByAgeGreaterThan(int age);
} // AS BEFORE
```

Wherever we have instances of `PirateRepository` we can now use that query. Spring should parse the method prototype and be able to execute the query we want. 

It's recomended the queries you write like this are well tested:


```java
//PirateserviceApplicationTests.java

@Test
	public void canFindPiratesOver30(){
		List<Pirate> found = pirateRepository.findByAgeGreaterThan(30);
		assertTrue(found.size()>0);
	}
```

## Task (10 mins): Find Raid by location
* Write a query to find a raid by location
* Write a test to make sure the query works.
* TIP: Think what repository it should be in. We want Raids back so RaidRepository.java

<details>
<summary>
Solution
</summary>

```java
//RaidRepository.java
    List<Raid> findRaidByLocation(String location);
    	
```

```java
//PirateserviceApplicationTests.java

	@Test
	public void findRaidByLocation(){
		List<Raid> found = raidRepository.findRaidByLocation("Tortuga");
		assertEquals("Tortuga", found.get(0).getLocation());
	}
	
```
</details>
# Summary

* Simple queries can be built up using JPA Query Methods (also called Derived Queries) by writing a method prototype in the repository. Spring will pick this up and try to action that query.
* This is a very simple but powerful way of quickly querying data. 


