# Using side-effects in React state

## Learning Objectives
- Understand what side-effects are
- Be able to setup the `useEffect` hook to control side-effects
- Be able to control which state changes trigger which side-effects

## Introduction

We can use `useState` to allow us to setup a piece of data into state, mutate (change) that data and see the results ***react*** to these changes by rendering to screen.

**Not all state changes are this simple** - When building applications using React we will come across slightly more complicated scenarios where we want to trigger some function to be called  only ***when another specific piece of the state is changed***.

In programming this is called making use of side-effects. Side-effects can be intentional or unintentional. We will talk about how to intentionally make use of side-effects using the `useEffect` hook.


## Side-effects

The word "side-effects" we often associate to medication.

* ***"Taking this antihistamine tablet may produce side-effects such as drowsieness"***

Thinking about what "side-effects" means, it really is a secondary effect. In other words it wasn't the primary goal to achieve drowsiness. The primary goal was to stop having an itchy nose from hayfever.

The concept is exactly the same in programming. Sometimes the functions we call have side-effects. Sometimes these secondary effects of doing something like calling a method or incrementing some value might unintentionally change other behaviours or values in our program as it's running.

## The problem

Create a new react app for this lesson:
```shell
npx create-react-app side-effects
cd side-effects
npm start
```

> TASK: 10 mins: Make a component with a number in state that has a button to increment and another to decrement that counter. Check it works as expected

```js
//App.js

import React, {useState} from 'react';
import './App.css';

function App() {

  const [number, setNumber] = useState(0);

  const handleInc = () => {
      setNumber(number + 1);
  }

  const handleDec = () => {
    setNumber(number - 1);
  }

  return (
    <div>
      <button value={number} onClick={handleInc}> + </button>

      <button value={number} onClick={handleDec}> - </button>

      <h2> Number is {number}</h2>
    </div>
  )
}

export default App;
```

If we wanted to render another number in a addition to the number we're showing but have it show as double whatever the first number is, how would we do that?

> Ask the class for suggestions. Hint to them we'd need another piece of state and another call to use state. `const [doubleNum, setDoubleNum] = useState(0);`

An immediately obvious answer is to add code into `handleDec` and `handleInc` so that when we call `setNumber` we also call `setDoubleNum`, too.

In summary we would need to:

* Create a new part of state called `doubleNum`
* Render it in our JSX
* Add a call to `setDoubleNum` in both `handleDec()` **and** `handleInc()`

Updated code for the entire component:

```js
//App.js

function App() {

  const [number, setNumber] = useState(0);
  const [doubleNum, setDoubleNum] = useState(0);

  const handleInc = () => {
    setNumber(number + 1);
    setDoubleNum(number *2)
  }

  const handleDec = () => {
    setNumber(number - 1);
    setDoubleNum(number *2)
  }

  return (
    <div>
      <button value={number} onClick={handleInc}> + </button>

      <button value={number} onClick={handleDec}> - </button>

      <h2> Number is {number}</h2>

      <h2> Double num is: {doubleNum}</h2>
    </div>
  )
}

```

The theory here is that, when we increment the number the double num should also render and the value should be double that of the first. **HOWEVER**..

> Check if this works...
This is **not** guaranteed to work, since the `setNumber` function is **asynchronous**, and takes time to run. So by the time we go to call `setDoubleNum`, it is likely that `setNumber` has not finished executing, and we will get the wrong result for `doubleNum`.

Even if it *did* work, we still have a couple of issues:

* **Not very DRY** - we need to repeat the call to `setDoubleNum`
* **Tightly coupled** - the code to double the number is very tightly coupled with the action of incrementing and decrementing the number. *What if something else were to become responsible for incrementing the `number`?* Then we'd need to move the call to the `doubleNum` over to that code.

## useEffect - the solution

React gives us the ability to say "when the state changes - trigger this side-effect". To do this we use the `useEffect` "hook".


In other words: We can trigger some code to be called in-turn when the state is updated in some way.

Let's see `useEffect` in action. We'll create a call to useEffect, so when the state changes in some way, it will call the code to double the number.

`useEffect` is just a function we call from in our component. It needs a function passed into it as an argument, and that function body contains the code to be called when the state updates.

Add the following below where the state is created:

```js
  useEffect(()=>{
    setDoubleNum(number *2);
  })
```

This useEffect registers the function we've passed in, so whenever **any** part of the state within this component is updated, the function is called.

We can check it's working, buy removing calls to `setDoubleNum` from the increment and decrement functions.

```js
//App.js

import React, {useState, useEffect} from 'react'; // MODIFIED

function App() {

  const [doubleNum, setDoubleNum] = useState(0); // AS BEFORE

  useEffect(()=>{             // ADDED
    setDoubleNum(number *2);  // ADDED
  })                          // ADDED

  const handleInc = () => {
    setNumber(number + 1);
    //setDoubleNum(newNum *2) // REMOVED
  }

  const handleDec = () => {
    setNumber(number - 1);
    //setDoubleNum(newNum *2) // REMOVED
  }

  return (
```

`useEffect` is essentially used to **"watch"** 👀 our state and call a function when that state changes. It's an extremely useful and powerful feature of React.

### So what?

At this point it might be easy to think "*Big deal, we could just leave the `setDoubleNum` calls in the handler methods!*" What if there were 10 more places you needed to call it from. What if there were 100 more places, and they were scattered across lots of files throughout the project?

Realistically, remembering every place where we're triggering a change to the value isn't a nice scalable way to solve the problem.

Now, no matter what happens to the `number` state, the doubling code will be called any time the state changes, and nobody needs to remember to call the double code manually.


## Optimising useEffect

When our components start to have a few different pieces of state (from a few calls to `useState`) the default `useEffect` applies to **all** state of the component, so any changes will trigger it.

Let's put a `console.log` into the function being passed into our `useEffect` call.

```js
  useEffect(()=>{
    console.log("use effect triggered");
    setDoubleNum(number *2);
  })
```

Notice when using it, one press on either increment or decrement leads to the log being printed twice. Why is this?

> Ask the class that question and encourage them to think about the number of times the state is being modified when pressing either + or -

We have a call to `setNumber` which modifies the state, then we have a call to `setDoubleNum` which also modifies the state.

**Do we want to trigger the hook when the `doubleNum` state is updated?**

No. We don't. It would be helpful if `useEffect` had a way of allowing us to specify *which* piece of the state to watch before triggering the effect.

`useEffect` actually optionally takes two arguments. The first argument is the callback we wish to trigger, the second is an array of "dependencies". This optional array of dependencies is an array of variables of any kind (including state variables) that will be watched to trigger the useEffect function.

The pattern for a useEffect call is as follows:

`useEffect( <function to call>, [ <array of dependencies to watch> ] );`

> What variable should we pass to the useEffect to trigger it only once when we increment or decrement?

We want to pass `[number]` as the second argument. That's because we only want this useEffect hook to be triggered only when the `number` part of the state is updated and not any other parts.

Let's update our code:

```js
  useEffect(()=>{
    console.log("use effect triggered");
    setDoubleNum(number *2);
  },[number])

```
Since this second "dependencies" argument is an array, it can take a lot of different variables to watch then trigger the effect. When giving it an array with > 1 element, the `useEffect` treats it as an **OR**. In other words, when any of the dependencies in the array are changed the trigger should be fired.

How many times do we see the log for one press of either `-` or `+`?

Now the hook is only called for the individual part of the state we want, rather than for **any** state update. This gives us the ability to finely control how the `useEffect` hook is used.

The **Performance implications** of making sure it's only being triggered on the appropriate change is extremely beneficial to the performance of our app' particularly as it grows.

## useEffect initial call

Looking closer at the number of times the console.log message in the last step appears, we can see that it seems to be called once when the component is initially rendered. This is intentional. We can control the subsequent calls through various combinations of things passed into the second "dependencies" argument but every `useEffect` call will always get called after the component is initially rendered.

> Ask the class how they might use the `useEffect` hook so it **only gets called once**, on its initial render.

**Solution**: use an empty array `[]` as the second argument to the `useEffect` call.

If a dependency array is provided but there are no dependencies present, `useEffect`'s function will be called once, just after the initial render of the component. `useEffect` isn't watching anything, and if it's not watching anything it cannot be triggered. It will not be called again throughout the lifetime of that component in the browser.

A common use case for using `useEffect` in this way is to make a call to an API at the beginning of a component's lifecycle.

Use the following table as a guide for reference.

| second argument   |      triggers      |  after initial render |
|----------|:-------------:|------:|
| [name, email] |  when either name OR email are updated  | yes|
| [name]  |    when only name is updated    |   yes |
| [] | initial render only  |    yes |
| missing* | every state update, no matter what | yes |

## Summary

So far, we've learned that:

* Being able to "observe" or "watch" some state for changes is better than manually triggering a function based on some external event.
* `useEffect` is always triggered when the component first loads, after its first render.
* `useEffect` watches state for changes, and triggers whenever the state is mutated
* `useEffect` takes an optional array as the second argument that allows us to be specific about when to trigger that particular useEffect hook.
* If we give `useEffect` no second argument, the effect will be triggered on **every single state mutation** and this isn't ideal in most cases.
* If we give `useEffect` an empty array as a second argument `[]`, it will trigger the effect once and only when the components first loaded.
