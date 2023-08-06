# Intro to React and State

**Duration: ??**

### Learning Objectives

- Be able to create a single component application
- Be able to use the JSX syntax
- Be able to use state to hold on to data
- Install and be able to use React Dev Tools

## Introduction

In the weekend homework, Intro to React, we learned that React is a library written in JavaScript that helps us build modern user interfaces for the web. In vanilla JavaScript we were doing a lot of repetative common tasks, such as our DOM manipulation. React helps us as developers focus on our applications functionality without having to go through the time consuming process of DOM manipulation calls (createElement, querySelector and appendChild, to name a few). It does a lot for us under the hood. 

Previously we have been dividing up our view logic into separate view files to keep our applications modular, and working with React is no different. Throughout the week you will be separating your UI into separate view files, which in React are called `Component`s. A `Component` is part of the React framework, and its role is to display a section of our user interface. Well-designed React applications have many small components with a single responsibility. However, in this lesson we will be focussing on learning the syntax used by React, so we will only have one component that describe the UI.


Today we will create a few single component applications to understand some core concepts of React, such as state and how loops and conditionals work in React. Then tomorrow start to build out multiple component hierarcys.



Lets start by building a simple app which will return Hello World. We will use a package called create-react-app to do this. 

```bash
npx create-react-app hello_world
cd hello_world
npm start
```

> Note: Remember to use `npx`. We are running this node package without installing it on our system, as compared to npm installing create-react-app. This is so we are always using the latest version of create-react-app, and were also not clogging up our file system with unnecessary downloads. 


Open up the code where we will do a bit of tidying up.

Delete the boilerplate code we don't need:

1. the logo file
2. the logo input in App.js
3. the JSX from App.js' return method

```sh
rm src/logo.svg
```

```js
// src/App.js

// DELETED
import './App.css';

function App() {
  return (
    // ...
  );
}

export default App;
```

If we look at the function's return statement, we can see there is some JSX there. We are going to be taking a more in-depth look at JSX soon, but for now let's delete the boilerplate:

```js
import './App.css';

function App() {
  return (
    // DELETED
  );
}

export default App;
```

We'll replace it with a simple "Hello World!" to ensure we don't have any errors at this stage.

```js
import './App.css';

function App() {

    const greeting = "Hello World"

  return (
    <h1>{greeting}</h1>			// ADDED
  );
}

export default App;
```



## Initialising State

Our data on the page is very static and not doing much. If we would like to make it more dynamic and change the greeting, we will need to introduce state.

State is a core fundamental of React and very important to understand early on in our learning. State, to put it simply, is our component storing data, and we can also change that data. 

Lets create our first piece of state in our app component. 

To help us manage our state we're going to use a [hook](https://reactjs.org/docs/hooks-intro.html). Hooks are a fairly recent introduction to React, but they streamline many processes which previously required many lines of code and different methods. We'll start by using `useState()` to manage a greeting variable state.

The `useState` hook comes from `react`, and so we'll need to import it. 


```js
import React, {useState} from 'react'; // ADDED
import './App.css';
```

The useState hook when invoked returns us an array of 2 elements.
1. a variable storing the value of our state
2. a function to update it

Thanks to destructuring in JavaScript, we can upack both of these elements into variables, ready to use through our application. Lets replace our greeting variable with our new state object and its function to update it.

```js
import React, {useState} from 'react';
import './App.css';

function App() {

    const [greeting, setGreeting] = useState(); // MODIFIED

  //..
}

export default App;
```

So we are calling our variable with the current state value "greeting" and the function to update the greeting value is called setGreeting. We *could* call these variables anything we want: but it is convention, and good practice, to prefix the function name with "set" to make clear what it will be used for:  `[variableName, setVariableName]`.


useState takes an argument of an inital value. This could be anything: a string, a number or even an object. Lets set the initial value of greeting to "Hello World".

```js
    const [greeting, setGreeting] = useState("Hello World"); // MODIFIED
```

We can display this on the page simply by using the `greeting` variable. 


## Updating the State

Next, we will create a button to update our greeting variable, therefore, updating the state. We know that the useState hook has given us a function that we are holding in a variable called setGreeting. We will use that. 

> Note: We should always use the provided function to update our state value. Directly manipulating the state can have unintended consiquences. 

First, lets add a button. 

```js
import React, {useState} from 'react';
import './App.css';

function App() {

    const [greeting, setGreeting] = useState("Hello World");

    return (
    <h1>{greeting}</h1>	
    <button>Change Greeting</button> // ADDED
  );
}

export default App;
```

Oh dear. Seems we have an error in the browser.

Module build failed (from ./node_modules/babel-loader/lib/index.js):
SyntaxError: /Users/user/Desktop/hello_world/src/App.js: Adjacent JSX elements must be wrapped in an enclosing tag. Did you want a JSX fragment <>...</>? (10:4)

A React component must return one of 3 things: 
- A JSX element
- A collection of elements
- null

Right now, we are returning multiple elements. React requires us to wrap this in a single element. We could use a `div` but instead we will use a common react tool called a **Fragment**.

### Fragments

The way to add fragments to our code is by surrounding them in empty tags.

```js
return (
    <>    // ADDED
    <h1>{greeting}</h1>	
    <button>Change Greeting</button>
    </>    // ADDED
  );
```

We can think of Fragments as a way of grouping DOM elements together without adding another DOM element to the page. They don't provide any more functionality than `div`s, and they can't be styled with CSS. However, they provide the following advantages:
 - Fragments do not clutter the DOM by creating an overly complex element heirarchy. As well as keeping things tidy, this will (marginally) speed up render time.
 - Fragments are seen as significantly more accessible to users using screen readers.


Back to our button, we want the user to click the button and then we are going to change the greeting from "Hello World" to say "Hello " + your name. 

First, lets hook up our button with an onClick even listener, which will trigger a function called `handleClick`, and to check this button works, we will do a simple `console.log()`.

OnClick will take in as an argument a callback, which will trigger our function in its body.

```js
    const [greeting, setGreeting] = useState("Hello World");

    const handleClick = () => { //added
    console.log("Click")
  }

    return (
      <>
    <h1>{greeting}</h1>	
    <button onClick={handleClick}>Change Greeting</button>  // MODIFIED
    </>
  );
}

```

Now we know thats working, lets use our setGreeting function, provided by our useState hook, to update the greeting.

```js
const handleClick = () => { // ADDED
    setGreeting("Hello John")
  }
```

Great! We can now see our change rendered to the page. Simply refresh the page to return to initial state. 

The key thing to understand about our state, is that whenever we update our state, our component will re-render, therefore showing changes to the user. Our React application reacts to the changes of our state. 

It might seem inefficient to render every time, but remember React uses the virtual DOM to only update the DOM elements that have changed, keeping it highly performant. There is where we start to see the real power of React. 

Lets say our handleClick will be passed in a name as an argument.

```js
const handleClick = (name) => { // MODIFIED
    setGreeting("Hello " + name) // MODIFIED
  }
```

Something unexpected happens when we change our code in our return statement.

```js
return (
      <>
    <h1>{greeting}</h1>	
    <button onClick={handleClick("John")}>Change Greeting</button>  // MODIFIED
    </>
  );
```

Our app has crashed! Seems our console in chrome is telling us React is having too many re-renders and has stopped the application to avoid an infinite loop.

When passing an argument to our event listeners callback, we have to wrap it in an arrow function. 

> Remember not to wrap the body in curly brackets unless you have implicitly said return.

```js
return (
      <>
    <h1>{greeting}</h1>	
    <button onClick={() => handleClick("John")}>Change Greeting</button>  // MODIFIED
    </>
  );
```

Why did this happen? Well the error occured because our component, `app` was being rendered an infinite amount of times. Why did it re-render? Well, when we used the previous syntax, handleClick was invoked immediately on creation of the button. Thats instead of what we want, which is to pass the function as a callback, ready to be called when the click happens. That then changed the state, which re-rendered the component, which then invoked our handleClick, which changed the state, which re-rendered the component and so on...

By wrapping it in arrow function, it stops the onClick invoking the function on creation because it is being passed as a callback.



### More State

Lets create a second state object in our component. We'll create a state variable called total and set its inital value to 0.

```js
  const [greeting, setGreeting] = useState("Hello World")
  const [total, setTotal] = useState(0); // ADDED

  const handleClick = (name) => {
    setGreeting("Hello " + name)
  }
```


Display the `total` in our return and also give it a button to `deposit`.

```js
    <h1>{greeting}</h1>
    <button onClick={() => handleClick("John")}>Change Greeting</button>

    <p>Total: £{total}</p> // ADDED
    <button onClick={deposit}>Deposit</button> // ADDED
```

Create the function that our onClick is triggering, deposit. 

> Note: We arent passing any arguments to deposit, therefore we dont need to wrap it in an arrow function. If we were to add an argument without the arrow function, the onClick would trigger the function on render. 


```js
const deposit = () => {                           
    setTotal(total + 10);                           
  }
```

When our apps start to get larger, it can get tricky to track our state changes, or debug state issues. Introducing, the dev tools. 


# Chrome Dev Tools

An other advantage of React is that there are powerful development tools in chrome. Download the following Chrome Dev Tool extension and you will have a new 'React' tab in the dev tool. (You might need to reopen the Chrome Dev Tools window after installing it).
[Link to React-Dev-Tools] (https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en)

By clicking on the different components in the React Dev Tools we can see any state that they have. You can also see it being updated live as the state changes.


### Task: (10 minutes)
Add a 'withdraw' button which decreases the total by the amount defined and passed down from the `App` component, preventing it from going below 0.

### Solution

```js

 const withdraw = () => {
    if(total >= 10){
      setTotal(total - 10)
    }
  }

    return (
      <>

    //...

    <p>Total: £{total}</p>
        <button onClick={deposit}>Deposit</button>
        <button onClick={withdraw}>Withdraw</button>
    </>
  );
}

export default App;
```

## Recap

<details>
<summary>
Which three things must a React component return one of?
</summary>
- A JSX element
- A collection of elements
- null
</details>

<details>
<summary>
What does useState return when invoked?
</summary>
1. Our initial state.
2. A function to update our state.
</details>

<details>
<summary>
How do we trigger a rerendering in React?
</summary>
By updating the component's state
</details>


# Conclusion

React allows us to render our UI as components, providing structure to our front end. It’s use of the virtual DOM and rerendering triggered by updating state method makes updating the DOM really efficient. 

We can now create single component applications, using JSX syntax to render information to the screen. We have seen how to trigger a rerender of the UI by updating a component's state on user interaction. 

Lastly, React Dev Tools offers a way of inspecting components' props and state during development.

## Additional Resources

JSX Gotchas - https://shripadk.github.io/react/docs/jsx-gotchas.html
