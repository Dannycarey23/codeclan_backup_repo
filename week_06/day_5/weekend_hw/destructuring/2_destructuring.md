# Destructuring

### Learning Objectives:

- Understand array destructuring in JavaScript and when we might use it
- Understand object destructuring in JavaScript and when we might use it.

## Intro

When we think of data structures, we probably think of words like array, list, hashmap. Something we are perhaps less likely to think about is an **object**.

In JavaScript, there are two core built-in data strucures:
- **Arrays**: an ordered data structure where values are accessed by index - their *position* in the data structure
- **Objects**: a collection of key/value pairs where values are accessed by *property name*.

*N.B. there are other data structures available in ES6 such as [Typed Arrays](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Typed_arrays), `Set`, `WeakSet`, `Map`, `WeakMap`... but these are not common or relevant here.*

JavaScript provides a syntax that allows us to unpack values from arrays and objects in to distinct variables. This is known as **destructuring**.

## Array Destructuring

Let's start by creating a new file called `destructuring.js`.

```zsh
touch destructuring.js
code .
```

Declare an array of names:

```javascript
const names = ["Fred", "Kate", "Cindy", "Ricky", "Keith"];
console.log(names);
```

Run the code using `node`:

```shell
node destructuring.js
```

Assume that we need two new variables to store the strings `"Fred"` and `"Kate"`. Without the destructuring syntax, we would assign them using their index:
```javascript
const fred = names[0];
const kate = names[1];
console.log(kate);
```

An alternative to this, using the destructuring syntax, would look like this:

```javascript
const [fred, kate] = names;
console.log(kate);
```

Here we are unpacking the first two items in the `names` array and storing them in two new variables called `fred` and `kate`. Note the square brackets on the left hand side of the assignment operator–this is not something we have done before!

We can skip over any variables we are not interested in by ignoring them. For example, we might not require the element at position 2 from the `names` array:

```javascript
const [fred, kate, , ricky] = names;      // CHANGED
console.log(ricky);                       // CHANGED
```

We can combine this syntax with the spread operator `...` to assign the remaining values to a new array variable called `remainigNames`:

```javascript
const [fred, kate, ...remainingNames] = names;       // CHANGED
console.log(remainingNames);                         // CHANGED
```

We can use this syntax as expected with an array that gets returned from a function. We will be making use of this when we come to cover React Hooks next week.


## Object Destructuring

We can use a similar destructuring syntax in order to unpack variables from objects. Where array destructuring is done by position in the array, object destructuring is done by property name.

Assume we have an object to represent a person, and we want to get their information back. Without destructuring, we could access this data using:
- `.` dot notation
- `[""]` square bracket notation.

```javascript
const person = {
  name: "Joni",
  age: 76
}
const name = person.name;
const age = person["age"];

console.log(name);
console.log(age);
```

To access these values using destructuring, we use curly braces on the left hand side of the assignment operator:

```javascript
const person = {
  name: "Joni",
  age: 76
}
const { name, age } = person;             // CHANGED

console.log(name);
console.log(age);
```

Note that the variable names need to match the name of the property. If you *really* need to assign to a new variable name, you could [look up the docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment#Assigning_to_new_variable_names).

Object destructuring allows us to specifiy exactly what properties of an object we need access to. We can use it for:
- objects we declare inline 
- objects that get returned from functions
- objects we import (from e.g. `npm` packages).

We will use object destructuring extensively in React. In particular, we will use it:
- to specify exactly what properties of a component's `props` object we are interested in
- to specify exactly what *named exports* from the React package to import for our different components.

...but more on those next week!

## Conclusion

The destructuring syntax is characterised by the use of either square brackets `[]` or curly braces `{}` on the left hand side of an assignment operator.

Destructuring is entirely "opt-in", and we can write equivelant code without it. However, it can **significantly** clean up our code by making it easier to read object properties and reduce the number of lines needed to declare variables.