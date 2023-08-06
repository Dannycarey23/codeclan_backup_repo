# Introduction to React - 1. Theory

### Learning Objectives

- Know what React is and why we use it
- Explain some of the key features of React
- Learn to think of UIs as component-based

## Introduction

### React - a Javascript UI library

React is a library written in Javascript, that allows developers to write Javascript to easily build modern user interfaces for the web.

What is the difference between a framework and a library?

- A library is a set of methods and objects written by someone else that typically solves just one individual problem for us, rather than solving lots of problems.
- A framework is a collection of several libraries under the one name that together offers a **complete** solution for most application features that someone would want to build.

### Why do we need React

Writing well-structured vanilla JavaScript applications, with a clear separation of concerns is difficult to achieve. There are also common tasks that we want to carry out, such as manipulating the DOM, which become repetitive and time consuming. For these reasons, developers over the years have created libraries and frameworks that help with web development. We are going to be using React to help us with our front-end development. React specifically helps us to build UI's (User Interfaces).

### Popularity

React says that it is 'A JavaScript library for building user interfaces'. Making applications that are fast and easier to develop has made React a very popular choice in the web community and it is widely used as shown by the following:

- [A list of companies that use React](https://stackshare.io/react)
- [State of JavaScript 2020 - Front-end](https://2020.stateofjs.com/en-US/technologies/front-end-frameworks/)

## Key Features

If we go to the [React website](https://reactjs.org/), we can see the main characteristics of React:

- Virtual DOM
- Component based UI - 'HTML' in JS with JSX

This week we are going to be using React to help us build well-structured view logic, using its DOM manipulation methods to make reading and writing to the (virtual) DOM more efficient than we have previously been able to achieve with vanilla JavaScript.

### Virtual DOM

Updating the DOM in our browser using JS is an expensive operation, it tasks a huge amount of time compared to us multiplying numbers or computing some simple value.  If after every little change our React application re-rendered the whole DOM, our app would be very inefficient and very slow.

React applications are known for being fast. So, how does it achieve this? React keeps a virtual version of the DOM in memory. When we make a change it updates this and compares it to the real DOM (a diff). It only updates the real DOM where necessary.

It is this step which allow us to write fast efficient applications by only having to describe a simple render.

### Component based UI

One of the core features of React is its component-based UI. React encourages us to break down our user interface into smaller parts called components. By doing this we can make sure each part is only looking after one thing. (*which software principle does this relate to?*) Single Responsibility principle! These can be reusable and are really helpful in separating the functionality of your app into independent parts. **This composability is extremely important to the success of UI libraries like React**. It allows us to write code that is DRY, adheres to Single Responsibility Principle, and is scalable - which is why the companies above have chosen to use React for their UI. 

It may be slightly different to how you're used to writing code, but when you start breaking down your UI into small components, you will start to notice the benefits of it. Using multiple small components as building blocks makes it easy to make changes without breaking the structure of the application or anything that is unrelated to the change. The apps that we will be building are still quite small, so it might feel unnecessary to break the UI down to such small components if they are not reused anywhere else in the app, but it helps you to get used to the React way of thinking and makes your projects easy to expand on when the building blocks are all there already. In modern React, components tend to just be functions, but you may come across some old-style React where a class-based structure is used. We will be using functional components as that is the preferred way at the moment and is more concise to write, but more on that next week!

React components may (but don't have to) use a React-specific syntax called JSX. JSX allows us to use HTML-like syntax when describing new elements, whether HTML elements or React components, which saves us time and can make our React code more readable. It can also help us in styling our application in a way that is consitent across the whole application. For example, we could have a component for a Button, but we would be passing it different details based on what we want the button to do or where we want to use it. But the button is always structured the same way, and we don't have to try to find out how we'd structured out buttons before in order to match it somewhere else. Some frameworks use a templating language for a similar purpose, writing HTML which can pull in information from a separate JavaScript file, but React allows us to do all of this in one place. (Some people prefer to have those things separate, it depends on the nature of your app as to what's most appropriate.)

## Video
Watch [this video](https://www.youtube.com/watch?v=1wZoGFF_oi4) for more explanation and visual examples of the component-based UI and learning to think in components.
