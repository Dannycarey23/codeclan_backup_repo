# try-catch & Exceptions

## Learning Objectives

- Know what Exceptions are used for
- Understand when to throw your own Exceptions


## Intro

What is an Exception? An Exception is a problem that we hit when running a program. In Java, an exception is a response to an exceptional circumstance that arises while a program is running.

Let's create an example

> Create a project called `Exceptions`
> 
> Create a `Runner` class

```java
//Runner.java

class Runner{
  public static void main(String[] args){
    int one = 1;
    int zero = 0;
    System.out.println(one / zero);
  }
}
```

Running this code will result in an `ArithmeticException` and the program will crash. This is an exception thrown by the system.

A list of most the common exception types can be found [here](https://www.tutorialspoint.com/java/java_builtin_exceptions.htm)

Wouldn't it be nice to be able to handle this exception without the program crashing. This is where ```try...catch``` comes in.

## try block

If we have a piece of code where we think an exception could arise then we enclose it within a ```try``` block. It's almost as if we are saying `try running this code and see if it works`:

```java
//Runner.java

class Runner{
  public static void main(String[] args){
    try {                    //ADDED
      int one = 1;
      int zero = 0;
      System.out.println(one / zero);
    }
  }
}
```

If we were to compile this we would get an error. If an exception arises then we talk about the exception being 'thrown'. If we think an exception is going to be thrown, then we need to write code to handle it. We need to 'catch' the exception in order to deal with it

## Catching exceptions

When we want to catch an exception we create a ```catch``` block. This block takes an argument which is the type of exception to be caught, in our case an ```ArithmeticException```

```
try {
  //code which may throw an exception
}
catch (<EXCEPTION TO BE CAUGHT>)
{
  //code to run when exception is caught
}


```

```java
//Runner.java
class Runner{
  public static void main(String[] args){
    try {
      int one = 1;
      int zero = 0;
      System.out.println(one / zero);
    }
    catch (ArithmeticException ex) {      // ADDED
      System.out.println("ERROR: " + ex.getMessage());
    }
  }
}
```

In our example the code in our `catch` block would only be run if the code in our `try` block throws an `ArithmeticException`. If another type of exception was thrown then this would not be caught and the program would crash when running.

However, you can add multiple ```catch``` blocks, each for a different type of exception i.e:

```java
try
{
   // statements causing exception
}
catch( ExceptionName e1 )
{
   // error handling code
}
catch( ExceptionName e2 )
{
   // error handling code
}
catch( ExceptionName eN )
{
   // error handling code
}
```


## Custom exceptions

When we write java classes that other developers are going to use, we might want to throw our own exceptions, to let them know when they're using our code incorrectly. You will see this next week when you are using Spring so we are just going to show you an example of a custom exception, where the programmer has written their own custom exception for a situation where the program may hit a problem.

> Give out example code

We've got a pet shop that stores Pet objects, Dogs, Cats or Fish, and can find them by looping through it's stock of Pets trying to find a Pet with a matching name.

What happens when we give our .findPetByName method a null instead of "Meowingtons"?

If you change this search term to null and run the code, you should get a `NullPointerException`.

This is a bit rubbish - it doesn't really give us enough information about what's gone wrong. 

### Creating a custom Exception

`NullPointerException` is pretty common, we're going to give more information about why our code might be failing, by instead throwing our own Exception

``` java
// NullStringException.java

public class NullStringException extends Exception{
  public NullStringException(String message){
    super(message);
  }
}
```


Our  Exception inherits from Java's Exception class, which makes it able to behave like the Java Exceptions we've seen thrown by the language itself.

The constructor calls the superclass' constructor to create an exception with a given String as its "message".

### Declaring our Exception

In any method we think our exception might be thrown we need to "declare" our Exception. This just means letting the compiler know that our method might throw this Exception.

We do this with the "throws" keyword, which we add to our method definition.

``` java
// PetShop.java
                                              
public Pet findPetByName(String searchName) throws NullStringException {
  ...
}  

```

Now we've got an exception, we can "throw" it using the throw keyword, and we do this in our `findPetByName` method at the point where we know we can't complete the search we're trying to do. i.e. if it's given a null as its search String.

```java
// PetShop.java

public Pet findPetByName(String searchName) throws NullStringException{

  if (searchName == null) {
    throw new NullStringException("Cannot search for a pet with null instead of a name String");
  }

  ....
}

```

Now let's try to compile our code with our new Exception being thrown.

We should get a compiler error, saying we must "declare" or "catch" our Exception before we're even allowed to throw it!






### catching our Exception

Now that we've declared the Exception might be thrown we must "declare" or "catch" our Exception before we're even allowed to throw it or else we will get an error

We do this using try-catch blocks.

We put our try-catch block where we call the method, not where the method is defined.

So in our ExampleTryCatch.java file, where we call our findPetByName function, we wrap that function call in a "try" block.

``` java
// ExampleTryCatch.java

public class ExampleTryCatch {
  PetShop shop;

  public void run(){
    setup();

    try{ // NEW
      shop.findPetByName(null);
    }
    ...
  }
}
```

We also have to catch the Exception if it is thrown, we do this in a catch block, immediately following our try block.

catch blocks follow try blocks, kind of like else blocks follow if blocks.

``` java
// ExampleTryCatch.java

  try{
    shop.findPetByName(null);
    System.out.println("Found pet: " + found.getName());
  }
  // NEW
  catch (NullStringException ex) {
    ex.printStackTrace();
    System.out.println("Exception Message:");
    System.out.println(ex.getMessage());
  }
// SAME BELOW
```

We can do whatever we like in our catch block, and we have access to the Exception object that was thrown, by convention we've named it `ex`.

Because our Exception class extends the official java language's `Exception` class, we have access to some methods from that superclass. ex.printStackTrace() is one of them, this  makes the exception's output in the console look more familiar, printing every point where the exception was thrown traced back through the execution of the code.

We can print out whatever we like however.

### finally blocks

We use `try` blocks to wrap things that may fail to execute properly, and may throw exceptions.

Some common examples of things that may throw exceptions are things like accessing a remote server to get data, or accessing our database.

If a problem occurs when accessing our database, our program will thrown an exception and just crash. If that connection with the database is still open, we might be blocking other people from using the database. In a big program / database, this is really not good.

We can use the "finally" block to do things that we need to happen whether the code in our try block was successful, OR threw an exception. The "finally" code will always run either way. This is perfect for clearing up after ourselves, for example by closing any open database connections.

But like with `catch` blocks, we can do whatever we like in `finally` blocks, so this program to logs a message to the console so that we can see that it has run.

``` java
// ExampleTryCatch.java

  try{
    shop.findPetByName(null);
  }
  catch (NullStringException ex) {
    ex.printStackTrace();
    System.out.println("Exception Message:");
    System.out.println(ex.getMessage());
  }
  // NEW
  finally{
    System.out.println("and finally...");
    System.out.println("I'm done.");
  }

```

### Optional (But recommended) in class example - 45 - 60min
Create a new file/class in your application with a method which gets called from Runner.java which reads a text file called 
inputtext.txt with 3 lines of text in it. The lines can be anything but for example use
```
Line 1
Line 2
Line 3
```

Now write a small method/function which reads from this java class and outputs the text to screen,
you will most likely need to google this as there are many ways to do this.
The purpose of this exercise is twofold

: Firstly to see how to create a second class file and call its method from main.

: Secondly to see that when using the various different file reader/input/inputstream classes it usually
requires a try catch exception to handle a FileNotFound Exception


Hint: To see where your text file should be put on your machine 
try running this first from your java program
```System.out.println(System.getProperty("user.dir")) ```

This output will show you where your java program is by default
looking for any input files. 
You can of course change this by specifying your own file path in your file reader.
###An example Solution
```java
//Runner.java
public class Runner{
    public static void main(String[] args){
        ExampleTryCatch myProgram = new ExampleTryCatch();
        myProgram.run();

        ReadFromFileExample readFromFileExample = new ReadFromFileExample(); //NEW
        readFromFileExample.readFromFile(); //NEW
    }
}
```

``` java
// ReadFromFileExample.java

  public class ReadFromFileExample {

    public void readFromFile() {
        try {
            System.out.println("Your inputtext.txt text file should be in the directory: " 
                    + System.getProperty("user.dir"));

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("inputtext.txt"));
            //Get first line
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                //Read lines until file reader returns null
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


