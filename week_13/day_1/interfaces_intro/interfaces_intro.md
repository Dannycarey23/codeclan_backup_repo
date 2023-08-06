# Introduction to Interfaces

## Learning Objectives

- What an interface is
- Why we use interfaces
- The benefits of using interfaces

## What is an interface ?

### In General

When we talk of interfaces we can think about the way one thing interacts with another e.g. think of how you interact with your computer. We use the command-line, or the Graphical User Interface (GUI). We use mice, trackpads, the keyboard etc, but we don't have to know what is going on inside our computer when we do something. We have different ways of inputting/outputting data to/from our computer, but in each case we are doing the same thing:

Entering data: keyboard, mouse, trackpad
Getting data back: screen, speakers

Another example is a plug socket - all objects need are 3 prongs and be able to take 240 volts. We don't manually wire our electrical items straight into the mains when we want to use them - we 'plug them in' - the plug/socket is the interface by which our house wiring is made available to our appliances. 

### In programming

When we write pieces of software we want to expose some it's functionality to the outside world, to allow other pieces of software to make use of that functionality. Those parts of that software which the outside world can see are its interface. 

#### Interface as a contract

When we are writing an object which interacts with other objects we often expect that one(or more) of the objects will have specific behaviour(s)/method(s) which we can use to interact with that object. We don't care how those methods are implemented, only that our object has that functionality. This expected functionality forms a 'contract' which objects have to fulfill.

Think back to our analogy of the plug socket. If we have a UK plug socket then to be able to plug an appliance into it it must have a UK plug (3 square pins, etc) and be able to run on the UK voltage of 240 volts - that is the contract.

In some programming languages, including Java, we can explicitly create such contracts using interfaces. To fulfill that contract we write classes which `implement` those interfaces. To fulfill the contract, those classes must implement *ALL* the behaviour specified in the interface.
Note - they can have additional behaviour. They do not just need to implement the behaviour in the interface. 

## Why use an interface ?

Often in programming, when creating classes and objects we are more concerned with __what__ an object does, i.e. what functionality it has, rather than being concerned about exactly __how__ it does it. Interfaces allow us to separate what a class does from how it does it. When we use interfaces we can write code which interacts directly with a class which implements that interface, or we can write code that interacts with the interface i.e. it only accesses functionality specified in the interface. This is called coding to the interface, rather than to the implementation. It is more favourable to do this as it makes our code more flexible. Rather than our code being able to work with only one specific class, our code will be able to work with any class which implements the interface, even if it hasn't been created yet. 

An example of this is the Java Database Connectivity (JDBC) API. It is made up nearly entirely of interfaces. The concrete implementations are provided as "JDBC drivers". This lets us write all the JDBC code independent of the database (DB) vendor. We can just change the JDBC driver without changing any line of our Java code (except where we have any hardcoded DB-specific SQL code) whenever we want to switch DB vendor.

## What advantages do interfaces give us?

By coding to interfaces, rather than the class(es) that implement them, we do not need to be dependent on the actual implementations of the interfaces. This is known as __loose coupling__ and means that our code can be much more flexible, as we can swap in/out other classes as long as they implement the interface that our class uses.

Again, think of your computer. It has many ports. Think of all the USB ports. What do you plug into them?
  - Headphones, printers, memory sticks, we can even charge devices(smart watches, cameras)
  - We plug them in to get access to functionality of our computer (even if it is just getting power).

> Think back to our plug socket - we unplug appliances/plug in other appliances. All we need to know is that the appliances have a UK plug and can take 240 volts.

When our classes are dependent on others this is known as __tight coupling__ and reduces the flexibility of our code.

> Think of some iPhones. If we want to plug in headphones we need ones with the correct connector, whereas with some other phones(and previous iPhones) you could use headphones with the standard 3.5mm jack. In this case the headphones and the iPhone are tightly coupled, but the phones with the 3.5mm jack are more loosely coupled.

By using interfaces we can concentrate on *what* a class/object does, rather than *how* it does it.

Next we will look at using interfaces in Java.


