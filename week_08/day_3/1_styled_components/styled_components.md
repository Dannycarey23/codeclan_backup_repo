# Styled Components


__Lesson Duration: 60 minutes__

### Learning Objectives

- What a Styled Component is
- Be able to install and use the styled-components library
- Understand the main features we can access when using a Styled Component.



## Introduction

In this lesson we're going to learn how to use the Styled Components library which gives us the functionality of CSS-in-JS support. CSS-in-JS is just as it sounds, it’s writing our CSS directly into our javascript files for the components we’re making. 


## Why would you use this?

One of the trickiest problems a developer faces while working on applications is choosing CSS selector names. As an application grows and multiple files are created, trying to keep consistent naming conventions while avoiding overwriting CSS selectors used elsewhere becomes more difficult due to them all living in the global namespace. Another issue that can occur is when we want to change something in an already existing CSS selector. We’d need to search the entire application to make sure it wouldn’t impact a different part of the site.

Using the styled-components library in our react application will allow us to create an html element and attach the styling to it in the same file. The elements we create will also be scoped to their component, meaning we can be confident about which element is going to change when we modify the CSS.

## Setup

Hand out start point and do the usual npm install and talk through it briefly. 

It’s an app that makes a request to the SpaceX API for the first launch using the `launchId` variable. 
Clicking the buttons increases or decreases the `launchId` by 1 (with guards to stop it going outside the available range).
It then fetches the launch data from the api and displays it in a component below.


Once they've seen the basic layout, this is a screenshot of what we’re working towards...

![Image of final website layout](images/finished_webpage_layout.png)


## Installing styled-components

After the normal process of `npm install` and `npm start` to make sure it’s setup and working properly, we’ll need to install the styled-components library.

```terminal
npm install styled-components
```

## Creating a Styled-Component

Now that our setup is done and our app is up and running, lets start by creating a styled component to replace the `<h1>` element in our `LaunchContainer`.
  
The first thing we'll need to do is import the library to give us access to it.

  ```js
  //LaunchContainer.js
  
import {useState, useEffect} from "react";
import styled from 'styled-components' // NEW
import LaunchSelector from "../components/LaunchSelector";
import LaunchDetails from "../components/LaunchDetails";

```

Now that we've got access to it, we can use this to create any HTML element as a styled component. This is done by calling the function that has the same name as the HTML element we want to create.

One important note for this process, we call these functions in a slightly different way. Because we're passing in a Tagged Template Literal, we use backticks ` `` ` instead of brackets `()`. 

Tagged templates are a more advanced concept, but more information can be found on the [MDN docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals#tagged_templates)



Now that we know what we need, lets create our styled `h1` and store it in a variable called `Title`.

```js
// LaunchContainer.js
import LaunchSelector from "../components/LaunchSelector";
import LaunchDetails from "../components/LaunchDetails";


const Title = styled.h1`` // NEW


const LaunchContainer = () => {
...

```
Lets give this styled component it's first bit of CSS and start using it on our page so we can see the changes. The whitespace doesn't matter for the template literal, just the semicolon between each CSS command. 




```js
//LaunchContainer

import LaunchSelector from "../components/LaunchSelector";
import LaunchDetails from "../components/LaunchDetails";

//UPDATED styled h1
const Title = styled.h1` 
  text-align: center;
`

const LaunchContainer = () => {
 ...
``` 
 
```js
//LaunchContainer

 return (
    <>
      <Title>SpaceX Launch Details</Title> // UPDATED
      <LaunchSelector 
        launchIncrease={increaseSelectedLaunch}
        launchDecrease={decreaseSelectedLaunch}
      />
      <LaunchDetails 
        launch={launch}
      />
    </>
  )   
```

We should now see our `<h1>` with added styling is being used in our app. Lets add a bit more styling to it to change the 
the font size, font and background colours, and adjust the margin and padding sizes.

```js
//LaunchContainer.js

const Title = styled.h1`
  text-align: center; 
  font-size: 1.5em;
  color: #fff;
  background-color: #062c43;
  margin: 0;
  padding: 1em
`

```

## Passing in props

Lets move to our `LaunchSelector` and update it to use some styled buttons with some extra functionality. We're going to see how we can define and pass in props to our styled button allowing us to choose the background colour for them. Lets get a basic layout of a button created and implemented.

```js
//LaunchSelector.js

import styled from 'styled-components'; //NEW

const Button = styled.button`    //NEW 
  font-size: 1em;
  padding: 1em;
  margin: .5em;
  border: 2px solid #ced7e0;
`

const LaunchSelector = ({launchIncrease, launchDecrease}) => {

  return (
    <Button onClick={launchDecrease}>Previous Launch</Button>    //UPDATED
    <Button onClick={launchIncrease}>Next Launch</Button>    //UPDATED
  )

}
```


To utilise this prop, we just need to pass a prop named `background` into the html element at render;

```js
  return (
    <>
    <ButtonContainer>
      <Button onClick={launchDecrease}>Previous Launch</Button>
      <Button onClick={launchIncrease} background="green">Next Launch</Button>
    </ButtonContainer>
    </>
  )
  ```

Lets see how we can now set up our styled component to be dynamic and either accept a colour of our choice by passing it in as a prop, or use a default colour if we don't pass one in.

We need to update the CSS in our `Button` to have a background property that will use a function passed in to the styled component's template literal. 

Our function is going to check if colour has been passed in as a prop, if it has we'll use it. If it hasn't we'll use a default colour instead.


```js
//LaunchSelector.js

import styled from 'styled-components'; 

const Button = styled.button`   
  font-size: 1em;
  padding: 1em;
  margin: .5em;
  border: 2px solid #ced7e0;
  background: ${(props) => props.background || "#9ccddc"};    //NEW
`

const LaunchSelector = ({launchIncrease, launchDecrease}) => {

  return (
    <Button onClick={launchDecrease}>Previous Launch</Button>    
    <Button onClick={launchIncrease}>Next Launch</Button>  //UPDATED
  )

}
```

Let's use a little bit of flexbox and adjust the layout of our buttons. We're going to create a styled `<div>` as a container for our buttons.

```js
//LaunchSelector.js

const ButtonContainer = styled.div` //NEW
  display: flex;
  background: #054569;
  justify-content: space-evenly;
`

const LaunchSelector = ({launchIncrease, launchDecrease}) => {

  return (
    <ButtonContainer>   //NEW
      <Button onClick={launchDecrease} >Previous Launch</Button>
      <Button onClick={launchIncrease} background="#dcab9c">Next Launch</Button>
    </ButtonContainer>   //NEW
  )

```

## Extending Styles

There might be some situations where we want to create two components that are very similar. We can use a built in constructor function that comes from the styled-components library.

We use it by calling the function and passing the styled component we've already made. It makes a copy that we can modify as needed without interfering with the original.

Lets move to `LaunchDetails` and update our `<p>` tags to be a styled `Paragraph`. 

```js
//LaunchDetails

import styled from 'styled-components';   //NEW

const Paragraph = styled.p`   //NEW
  margin: 0;
  padding: 1em;
  background-color: #ced7e0;
  color: #062c43;
`
const LaunchDetails = ({launch}) => {

  if (!launch){
    return <p>Loading...</p>
  }

  return (
    <>
      <h3>{launch.mission_name}</h3>
      <Paragraph>Flight Number: {launch.flight_number}</Paragraph>   //NEW
      <Paragraph>Year: {launch.launch_year}</Paragraph>   //NEW
      <Paragraph>Rocket: {launch.rocket.rocket_name}</Paragraph>   //NEW
      <Paragraph>Details of launch: {launch.details}</Paragraph>    //NEW
    </>
  )

```

We're nearly there. It looks like there's just one more part we're need to refeactor and that's our `<h3>`.

We want it to be very similar to the `Paragraph` componet we've already created, with a few additions and a change. Lets use the constructor to copy the `Paragraph` and make a bigger version of it.

```js
//LaunchDetails

...
const BigParagraph = styled(Paragraph)`   //NEW
  font-size: 1.5em;
  padding: .5em;
  border-bottom: 1px solid #062c43;
`

const LaunchDetails = ({launch}) => {

  if (!launch){
    return <p>Loading...</p>
  }

  return (
    <>
      <BigParagraph>{launch.mission_name}</BigParagraph>    //UPDATED
      <Paragraph>Flight Number: {launch.flight_number}</Paragraph>

...
```

## Conclusion
In this lesson we've learned how to add styled components to our React applications to give us basic HTML elemnts with css already applied. This is being achived by pulling in the styled compnents library and following the rules it lays out. 

One of the most important things we've seen is invoking our functions using the tagged template literal syntax. This involves calling our function using ` `` ` and passing in a string of the CSS rules we want.

One last important note is that we can still use the traditional imported CSS stylesheet files that we've seen and used before, but enhancing it where we need to by creating a styled component.
