# Singleton Pattern

## Objectives

- What are design patterns?
- What is the singleton pattern?
- How would you implement the singleton pattern
- What is the singleton pattern used for


## Intro - Design Patterns

Design patterns are typical ways of solving common programming problems. They are like a blueprint which a programmer can customise to solve a particular design problem.

The idea of using design patterns in programming was introduced in the 1994 book [Design Patterns - Elements of Reusable Object-Oriented Software](https://www.amazon.co.uk/Design-patterns-elements-reusable-object-oriented/dp/0201633612/ref=sr_1_1?crid=35H73CJ5UV502&dchild=1&keywords=design+patterns+elements+of+reusable+object-oriented+software&qid=1598540219&sprefix=design+pat%2Caps%2C138&sr=8-1) written by Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides who are commonly known as the 'Gang of Four' (or 'GoF')

According to the GoF design patterns are primarily based on the following principles of object orientated design:
 * program to an interface not an implementation
 * prefer composition over inheritance

## Singleton Pattern

One of the simplest design patterns is the Singleton Pattern. This pattern refers to creating an object. The Singleton Pattern ensures that only one instance of a class is created. This single instance is global, so that the whole program can access it.

Using the Singleton Pattern solves two problems at the same time, so it breaks the __Single Responsibility__ principle:

* It ensures that a class has just one instance
* It provides a global access point to that single instance

## Why have a single instance of a class?

It's common to have one class that's used as an overall program context that's responsible for looking after all the other objects in your program. An example is the `ThemePark` class in the Theme Park homework.

Generally, we should use a singleton when managing access to a resource which is shared by the entire program. There are times where we may want to control access to some shared resource, for example a database, or a file. If we have a class which handles connections to a database, we don't want to create a new instance of that class every time we want to interact with the database. It's much better to have a single instance of that class which we access whenever we want to access the database. 

Normally when we create an instane of class we use a constructor i.e. by using `new` but when we call new we *always* get a new instance of the class. Thus we cannot have a single instance of a class if we can create it by calling `new`

## How do we implement a singleton?

To implement a singleton there are two steps:

1) we make the default constructor `private`. This stops us creating instances of the class using `new`
2) we create a static method to create an instance of the class - this acts as a constructor. The first time this method is called it calls the private constructor to create an instance of the class. This instance is then stored in a static field. Whenever we call the method again it simply returns the instance stored in the static field.

Let's have a go:

> Create a project called SingletonExample
> 
> Create a `Singleton` class and a `Runner` class

```java
//Singleton.java

public class Singleton {
    private static Singleton instance = null;

    private String data;

    private Singleton() {
        data = "Hello, I am part of a Singleton Class";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getData() {
        return data;
    }

    public void setData(String newData) {
        data = newData;
    }
}

```

The `getInstance()`` method should create the instance if it is null. Otherwise it should just return the instance.

Notice that the singleton property INSTANCE is an object of type `Singleton`. This is the same type as the class. It is possible to do this, but generally not recommended unless you're trying to do something like this pattern.

The class has a static method for controlling access to an instance of itself. This is because only that class can know if there's been a static property of it's own type created.

```java
//Runner.java
public class Runner {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton1.getData());

        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton2.getData().toUpperCase());

        singleton2.setData("The data has changed");

        Singleton singleton3 = Singleton.getInstance();
        System.out.println(singleton3.getData());

    }
}


```


## Singleton in practice

Anywhere we want only one instance of a particular class, we can use the singleton pattern to make that happen. There is also a common use-case when building back-end web systems. We might only want to have one object that's responsible for accessing a database. This is common because often when connecting our applications we don't want multiple connections between our application and our database. To do that we'd make the database handler in our app' a singleton.

## Summary

The Singleton Pattern is a simple design pattern which ensures that only one instance of a class is created and that that instance can be accessed globally. 

You will see this pattern being used next week when you are using the Spring framework.