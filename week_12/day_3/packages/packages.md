# Packages and Access Modifiers

## Learning Objectives

- Understand that you can organise your code in packages

## Introduction to packages.

Packages are groups of classes in a folder. Their purpose is to help organise your classes in a structured way. You have already seen them when you created a new project. You had 2 packages, one to store your code, and one to store your unit tests.

Now we are going to work off a simple project that has a few packages.

> Hand out packages start point


[Draw a box similar to one from this site] (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

We can see we have two packages, one for animals and one for humans. These packages will contain the respective code. A dog is inside the animal package and has a public string name and bark, and human class inside the human package and has a teach method that accepts a dog class.

If we we were look at the folder structure of our codebase, it would look like this (each package name is its own folder):

```

    - codeclan
        | - com
            | - packagesexample
                | - animal
                    | - Dog.java
                | - human
                    | - Trainer.java
```

In JavaScript, when we wanted the Trainer class to see the Dog class, we would write a `require("./../animal/dog")`. In Java we need to be more explicit so we say

```
import animal.Dog;
```

We could say

```
import animal.*;
```

This will import all classes inside the animal package. This, however, is considered bad practice if we only need one of those classes. So lets change the import back to only import the Dog class.


We can create sub-packages in packages (they will just become subfolders).

Lets create a package called air inside animal. Package names are written in lower camel case to avoid conflict with the names of classes or interfaces.

In the `air` package create Bird class.



In the bird class we are going to create a method called `speak()` that returns the string "Tweet Tweet".

```
public String speak() {
    return "Tweet tweet";
}
```


Now in the Trainer class we are going to create a `trainBird()` method that takes in a bird and returns the result of calling the birds speak method.


```
public String trainBird(Bird bird) {
    return bird.speak();
}
```

Inside Trainer, we can import the Bird like so

```
animal.air.Bird;
```

Note we cannot say `animal.*;` because * is not recursive, only pulls it in from that folder and not subfolders.

## Protected keyword

So far we have only really dealt with `private` and `public` access modifiers.

There is a third on in Java known as `protected`.

Unlike private, which can only be accessed within the class itself, `protected` can only be accessed from any class within the package.

> Change the dogs `bark()` method to `protected`.

Note now that in the Trainer class  there is an error telling us that `bark()` is `protected`.  We would only be able to invoke `bark()` from Trainer if they were in the same package.

> Change `bark()` back to public


## Summary

Packages are a good way to structure our files and group common classes or behaviours together.

The protected keyword gives us an additional level of security for our variables and methods should we only wish them to be accessed from within the same package.
