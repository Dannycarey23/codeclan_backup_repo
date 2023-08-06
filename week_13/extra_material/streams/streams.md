# Java Streams

## Learning Objectives
  - Understand what streams are
  - Understand lambda expressions and method references.
  - Understand the different kind of available stream operations.
  



## What are streams and how they work

Streams give us a way of processing data ‘in flight’. In other words, we can process data while it’s moving through our program.

In this lesson you will learn how to work with Java streams and how to use the different kind of available stream operations. 

Start a new IntelliJ project called JavaStreams.

```
#IntelliJ
Create a new Java Class in main folder called Streams
```

Now let's write a piece of code that allows us to `filter` and `sort` a list of names using streams and then print the result.

```java
//Streams.java

public class Streams {

    public static void main(String[] args) {

        List<String> myList = Arrays.asList("amanda", "alex", "sandy", "alina", "sky");

        myList
            .stream()                             // get the stream from the list
            .map(String::toUpperCase)             // apply intermediate map operation passing in the String toUpperCase reference
            .forEach(result -> System.out.println(result));          // use forEach to run the lambda expressing printing the contents

    }
}
```


```
output:
AMANDA
ALEX
SANDY
ALINA
SKY
```

In short - the stream applies the map operation to the data then pipes it into a forEach where we print out each element. 

We'll break-down how this works in the following parts of the lesson.

## Creating streams

We can create a stream a few different ways - these are:

* From existing collections or lists of data
* Directly - using a Stream helper method like `Stream.of`

### Creating Stream from existing Collection


Lists and Sets have the method `stream()` to either create a sequential or a parallel stream. Parallel streams are capable of operating on multiple threads. In this lesson we'll focus on sequential streams.

Calling the method `stream()` on a list of objects returns a regular object stream. In our example `myList.stream()` returns a stream object which we can then apply operations to.


### Creating a stream from scratch (without a list)

That static helper method `Stream.of()` will create a stream from a bunch of whatever object we put into it. We can put as many arguments into this as we like.

```java
//Streams.java

    Stream.of("amanda", "alex", "sandy", "alina", "sky")  // UPDATED (delete the list and call to .stream()
              .map(String::toUpperCase)
              .forEach(result -> System.out.println(result));

```


## Stream operations (methods we can do on the stream)

Stream operations are methods we can call on the stream's object that allow us to manipulate the stream and perform functions on it. Thinking of a stream as a stream of water, operations can be thought of as valves and filters that do different things to the water as it moves along.

Most stream operations accept one of two things:
* a _lambda expression_ parameter
* a _method reference_

There are two types of stream operations. Intermediate and Terminal:

* Intermediate operations return a stream. This allows us to chain multiple intermediate operations onto each other. Think again of connecting lots of compatible pieces of pipe together. In the above example, `map` is an intermediate operation.
* Terminal operations return either `void` or a non-stream result.  In the above example, `forEach` is a terminal operation. Think of a terminal operation as being the end of the pipe.



#### Intermediate Operations 

`map()`, `filter()`, `distinct()`, `sorted()`, `limit()`, `skip()`

#### Terminal Operations 

`forEach()`, `toArray()`, `reduce()`, `collect()`, `min()`, `max()`, `count()`, `anyMatch()`, `allMatch()`, `noneMatch()`, `findFirst()`, `findAny()`



To be able to properly use these stream operations we need to understand how to use them. Most of them can accept a **lambda function** OR a **method reference** as arguments.

This is a very important point as it's the first time we're seeing passing a method/function into a function in Java.

We'll look at our current example fist - which is using a lambda function expression.

### Lambda expression / function

Lambda expressions are short blocks of code which take in parameters and return a value - very similar to using arrow functions in JS and passing them as _callbacks_. Lambda expressions are similar to methods, but they don't need a name and they can be implemented right in the body of the method.

The structure of a lambda is as follows:

```
(argument) -> System.out.println(value)
```


and has a multi-line form:

```java
(comma, separated, arguments) -> { 
   multiline statements;
   multiline statements;
}
```

**Note: Java isn't a functional programming language - this means functions like this cannot be written directly into the source code the same way they can be written in languages like JavaScript or Scala. In java, they need to be assigned to objects which implement the functional interface.**

### Method References

Java allows us to pass a method **reference**  via the `::` operator symbol. We can do this anywhere we're allowed to pass a lambda expression.
This works as long as:

* The method is static
* It's a "pure function" - so it takes an input and returns an output without mutating state.

Looking at our code, we can pass the `println` method reference to the `forEach`. It has the same effect as doing the print in a lambda.

```
       .forEach(System.out::println);
```

#### (Optional) Creating our own stream operation method references

This is as simple as making a static method that takes a single argument and returns a single value.

```java
static int doSomething(int input){
	return input * 2;
}
```

Use it in your stream using the method reference prepending the call with the class name and the method reference operator `::`. In our class called `Streams`:

```java
Stream.of(1,2,3,4)
	.map(Streams::doSomething)
```

### Streaming data back to a List with collect

Going back to our first example in Streams.java:


```java
Stream.of("amanda", "alex", "sandy", "alina", "sky")  // UPDATED (delete the list and call to .stream()
          .map(String::toUpperCase)
          .forEach(result -> System.out.println(result));
```

What happens to the stream once it's terminated?

After the forEach is called in this example the data disappears and is lost - that's because we're not capturing the output of the stream.

Think of it as we've not attached an outlet pipe on the bottom of our connected together valves and we're losing the water.

We need to understand how to use the `collect()` terminal operation.

The `collect` allows us to put a bucket at the bottom of our stream - in effect.

```java
    Stream.of("amanda", "alex", "sandy", "alina", "sky") 
            .map(String::toUpperCase)
            .collect(Collectors.toList());
```

The `Collectors` class contains a variety of static helper methods that allow us to _choose_ the type that we want to funnel the stream into. Here, we are using `toList()` to return a list.


Since we're returning a list - we can now assign the result:

```java
List<String> output = Stream.of("amanda", "alex", "sandy", "alina", "sky")
        .map(String::toUpperCase)
        .collect(Collectors.toList());
```

### Reducing a stream to a single value

**Reduce** combines all elements of the stream into a single result but allows you to choose how it's reduced.

The reduce method accepts three parameters: an identity value, a `BiFunction` accumulator and a combiner function of type `BinaryOperator`. Since the identity values type is not restricted to the Person type, we can utilise this reduction to determine the sum of ages from all people.

```java
    int total = Stream.of(1, 2, 3, 4, 5, 6, 7)
            .reduce(0,(sum, num)-> sum += num);
```



## Examples: Things we can do with Streams

The power of streams comes from being able to do really powerful things by chaining multiple operations together. We'll use `forEach` just to print where appropriate - keep in mind `forEach` is a terminal operation.

### map

**Apply any transformation we want to each element of the stream**

```java
    Stream.of(1, 2, 3, 4, 5, 6, 7)
            .map((num)-> num *2)
            .forEach(System.out::println);
```


### filter

**Remove things from the stream based on certain conditions or values**

```java
    Stream.of(1,2,3,4,5,6,7)
            .filter((num) -> num %2 == 0)
            .forEach(System.out::println);
```

### reduce

**Reduce to a single value - like a number total or concatenation of lots of separate strings**

Note: reduce is a terminal operation

```java
    int total = Stream.of(1, 2, 3, 4, 5, 6, 7)
            .reduce(0,(sum, num)-> sum += num);
```

### sorted

**sort the stream**

```java
    Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
            .sorted()
            .forEach(System.out::println);
```

### limit

**limit the number of outputs**

```java
    Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
            .sorted()
            .limit(4)
            .forEach(System.out::println);
```
### average

**get the average of all the values in a stream**

```java
double average = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .mapToInt((n) -> n)
                .average();     // average terminates
```
Here the `mapToInt()` is needed to convert to an `IntStream` giving us access to even more `int` specific stream operations - like average.

### max

**find the largest value in the stream**

```java
 int result = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
            .mapToInt((n) -> n)
            .max()
            .getAsInt();
```

### min

**find values less than this value only**

```java
 int result = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
            .mapToInt((n) -> n)
            .min()
            .getAsInt();
```

### Take a peek()

**The peek intermediate operator is great for peeking in on the stream between the operations that are applied to it**

```java
    int out = IntStream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
            .peek(n -> System.out.printf("original: %d%n", n))
            .map(n -> n * 2)
            .peek(n -> System.out.printf("doubled : %d%n", n))
            .filter(n -> n % 3 == 0)
            .peek(n -> System.out.printf("filtered: %d%n", n))
            .sum();
```

### More operations

Streams support plenty of different operations. We've already learned about the most important operations like `filter` or `map`. I leave it up to you to discover all other available operations (see Stream [Javadoc](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)). Instead let's dive deeper into the more complex operations collect, and reduce.

## Optional: Specialist Streams

Besides regular object streams ships with special kinds of streams for working with the primitive data types int, long and double. As you might have guessed it's IntStream, LongStream and DoubleStream.

### IntStream

IntStreams have int only operators and also have static helper methods for creating int-only Streams.

As an example `IntStream.range()` can replace the regular for-loop. Also works with `LongStream`.

```java
IntStream.range(1, 5)
                .mapToObj(num -> "number: " + num)
                .forEach(System.out::println);
```


## Bounded v Unbounded data

It can be helpful to understand two terms when reasoning around streams: "bounded" and "unbounded".

### Bounded data

We actually deal with bounded data all the time. Bounded data are all the objects and lists of objects that we're quite familiar with already. They're categorised as bounded as there's an upper limit on the amount of that data we can hold.

For example if we have a list of some object there's a _finite_ number of elements of that object we can hold in memory. That is a rather huge number and depends on the memory in the computer - but we need to appreciate that it's still limited.

### Unbounded data

Unbounded data is the idea that the amount of data is infinite. It's potentially never ending. This idea is hard to get our heads around because surely there's limits on the amount of data we can have in memory as we discussed when talking about Bounded Data?

This is where Java Streams come in. Java streams are a way of accessing and processing an infinite "stream" of data.

## The Bigger Picture

Let's have a think about the bigger picture.

**Ultimately one of the benefits of streams is they allow us to start processing data before all the data has arrived**

This means that if we were to use streams in a big system with a huge amount of data we wouldn't need to "wait" on the data "arriving" into an object that's bound in size before starting to work on the output.

This means that if used in a large system that's streaming data around we don't need to wait for the data to exist before we start processing the stream.

## That's it

As you saw, Streams are a very powerful tool to chain multiple operations in Java that can make your application faster during runtime and also help us to avoid the sometimes unnecessary mutation of our data.

* Streams help process data "in flight".
* Streams use operators to manipulate and process the stream as it moves along - similar to different valves that you'd connect to a pipe. Operators can be connected together if they're intermediate.
* Lambda functions are like JavaScript arrow functions and are passed into stream operator methods.
* Method references are another way of giving stream operators functionality


For more information, check [Stream Javadoc](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#NonInterference) package documentation.



