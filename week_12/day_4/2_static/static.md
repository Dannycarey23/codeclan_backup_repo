## static

Java has a the keyword `static` that can be used in two different situations that have a very different effect.

* When creating variables or properties
* When creating methods

## static variable / property

If we mark a variable/property as `static` in a 
class called Vat.java :

```java
public static String vat_percentage;
```

Then that means that _every instance of the class Vat will share the same value for that property_. This is a way of making every instance of a class have a property (as normal) but when it's static the value will be the same in every instance of that class, no matter what. This is throughout your application. So every time you use or change the vat_percentage variable it will change throughout your application.

### static variable uses

`static` on properties or for variables isn't that common. However it is a good way of changing some property or behaviour of every instance of a class at once. That makes it appropriate for configuration or for values that don't change very often but are used many times, like DB connection strings (eg "url://127.0.0.1:5017/shop_db"), vat_percentage, etc.


## Static method

A static method is simply a method that can be called on a class. Specifically it can be called on a class *without* the need to make an object first. With non-static methods on classes, to call them we first need to instantiate objects of those classes.

```java
class Foo {
	public static void setup(){
	   System.out.println("doing setup stuff...");
	}
}
```

To call this `static` method we **don't even need to create an instance of `Foo`**. All we need to do is call it on the classes name like so:

```java
Foo.setup();
```

Notice `Foo` here is the class, not the object. We've not created an instance of `Foo` at all.
As with the static variable/property, any code inside this method is available throughout your application, i.e. only ONE instance of the setup method will ever exist in the JVM.


### Examples of static methods

We've actually used static methods a lot without really giving it a second thought here's a list of a few that we've probably came across so far:

* `Math.floor()` - Actually all of the `Math` methods are defined as static.
* `Arrays.` - any of the `Arrays` utility methods are all static!
* `String.format()` - we've used this to format strings a particular way - it's a static method. Actually there are lots of useful static methods on the `String` class.

You might notice that static methods are extremely useful as utility methods. You might even also notice that static methods are particularly useful when you don't need to store any data in the object. 

Any time you want to write a method, that:

*Is used as a helper function or
*Does not store data.

### Benefits

One of the nice things about static methods is that we can avoid creating an instance of a class when we just need to call a method of that class.

For example: If we've got a `Calculator` class that has some (non static) methods like `add()`, `subtract()` it would be wasteful to need to create an instance of it just to use its methods...

```java
class Calculator {

	public int add(int num1, int num2){
		return num1 + num2;
	}
}
```

To use it, we need to:

```java
Calculator calc = new Calculator();
int result = calc.add(12, 9);
```


Alternatively if we make `add` a `static` method as so:


```java
public static int add(int num1, int num2){
	return num1 + num2;
}

```

Then we can use the method without having to first create an instance of the class:

```java
int result = Calculator.add(12, 9);
```

### Caution on this
This is really nice! But as with everything, it has some drawbacks. 

Since statics exist only once in memory, if you misuse them you could end up changing values in your application, even if you don't need to change them. If you have a static variable name for a Person class, no matter how many objects are instances of the Person class, the value of name - since it is a static property of the Person class - will always be the same for all instances. If you change it, all instances will change.

### Summary:
Statics are useful as helper or utility functions or for values that change very rarely.


