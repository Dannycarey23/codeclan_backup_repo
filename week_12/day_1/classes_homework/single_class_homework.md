# Homework - Simple Classes

Create 3 single classes with methods to perform some functionality.

This is a TDD exercise. Write the test first then create the method to get the test passing.

## MVP:

#### Calculator

- Create a Calculator class. 
- This should have functions for Add, Subtract, Multiply and Divide. 
- Your methods should take in two ints to perform the calculations on (except the Divide method. This should take two doubles as arguments).

*HINT: you will need to have an empty constructor function or no constructor function at all!(The compiler automatically provides a public no-argument constructor for any class without constructor)*  

#### Water Bottle

- Create a water bottle class with a volume property.
- The volume should start at 100.
- Add a drink function that takes 10 from the volume each time it is called.
- Create an empty function that brings the volume down to 0.
- Create a fill function that fills the volume back to 100.

## Extension:

#### Printer

- Create a Printer class that has a property for number of sheets of paper left.
- Add a method to print that takes in a number of pages and number of copies.
- The print method will only run if the printer has enough paper. If it runs it will reduce the value of the paper left by number of copies \* number of pages.
- Add a toner volume property to the class.
- Modify the printer so that it reduces the toner by 1 for each page printed.
