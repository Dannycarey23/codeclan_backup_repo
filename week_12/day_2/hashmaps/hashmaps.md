# HashMaps

Duration - 30 minutes

## Learning Objectives

- Describe the purpose of a HashMap
- Use some important HashMap methods
- Use a HashMap in your projects

### Intro

When we were learning JavaScript, we saw how useful it was to store keys and values in a structured way - using objects:

```js
  person = { name: "Sal", occupation: "pizza chef" }
```

It allowed us to store and retrieve data without having to worry about the *order* of the data.

Most languages have a similar construct, and in Java, these are called HashMaps. (In other languages they might be called hashes, dictionaries, or associative arrays.)

Let's look at how we would initialise a HashMap in Java.

Create a new project in IntelliJ and call it HashMapDemo.

Create a new Java class in the main package again called HashMapDemo.

```java
  // HashMapDemo.java
  import java.util.HashMap;

  public class HashMapDemo {
    public static void main(String[] args) {
      HashMap favouriteFruits = new HashMap();

      favouriteFruits.put("Alice", "Apple");
      favouriteFruits.put("Sarah", "Banana");
      favouriteFruits.put("Bob", "Strawberry");

      System.out.println(favouriteFruits.get("Alice"));
    }
  }
```

So this works OK; the program outputs Alice's favourite fruit as expected.

Notice that we're initialising the HashMap as being empty, then using the `.put()` method to add keys and values.

However, if we build our project, rather than just running it, you might notice that the compiler is giving us a warning.

```
Choose Build > Build Project
```
> Note: If the warnings don't appear as expected, it can be introduced by doing the following:

* Introduce a blatant error
* Build > Build Project
* The errors list will appear
* Fix the blatant error
* Build > Build Project
* Cmd + 0  (Command + zero)
* Should now be able to see the warning from the compiler.

```
Note: HashMapDemo.java uses unchecked or unsafe operations.
```

The compiler is warning us that we should specify the _types_ of the keys and values we are putting into the HashMap. Let's try again.

```java
  // HashMapDemo.java
  import java.util.HashMap;

  public class HashMapDemo {
    public static void main(String[] args) {
      HashMap<String, String> favouriteFruits = new HashMap<String, String>();

      favouriteFruits.put("Alice", "Apple");
      favouriteFruits.put("Sarah", "Banana");
      favouriteFruits.put("Bob", "Strawberry");

      System.out.println(favouriteFruits.get("Alice"));
    }
  }
```

Much better! Now Java will complain loudly if we try to set the key or value to anything other than a String.

## Keys

A note about HashMap keys: you can use any class as a key, provided that it implements the `.equals()` and `.hashCode()` methods. In the example above, `String` fits the bill, but we can use any class that implements these two methods.

## Values

When you store a value in a HashMap, it will always store an object, rather than a primitive type. Take a look at the following code.

```java
import java.util.HashMap;

public class HashMapDemo {
  public static void main(String[] args) {
    HashMap<String, Integer> ages = new HashMap<String, Integer>();

    ages.put("Alice", 52);
    ages.put("Bob", 24);

    Integer aliceAge = ages.get("Alice");

    String output = "Alice's age is " + aliceAge.toString();
    System.out.println(output);
  }
}
```

Because the value of Alice's age is a full integer object, we can call `toString()` on it. (We couldn't do this if it was a primitive type!)

In other languages we are used to seeing the key relate to more than one value. In Java how we do this is by putting a class as a value. For example if we wanted to store both Alice's favourite fruit and age, we could just have a Person object that we pass in as the value. In our person constructor we could then specify all the information we'd like to store about Alice, or any other Person, and find the required information by key.

## Methods

Let's take a look at some of the most common methods we can call on our HashMap:

```java
  favouriteFruits.put(key, value) // inserts a new entry into the HashMap
  favouriteFruits.get(key) // gets the value for the given key
  favouriteFruits.size() // returns the size of the HashMap as an integer
  favouriteFruits.clear() // clears all entries from the HashMap
  favouriteFruits.containsValue(value) // returns true if the HashMap contains the value
  favouriteFruits.remove(key) //removes the entry with the given key
```

### Task

1. Create a HashMap of keys and values for the populations of some countries. Here is some sample data (don't forget to think about the types of your keys and values!):

```
UK: 64,100,000
Germany: 80,620,000
France: 66,030,000
Japan: 127,300,000
```

2. Output some values from the HashMap using `.get(key)` and `system.out.println()`.
3. Investigate the use of the `.values()` and `.keySet()` methods on HashMap.
4. Alongside the population, try to store the continent and capital for each country.
Make a function that outputs: `In ` + country + ` there are ` + population + ` people. The capital of ` + country + ` is ` + capital + ` and it is in ` + continent + `. ` .
Hint: you will want to create a Country class.
