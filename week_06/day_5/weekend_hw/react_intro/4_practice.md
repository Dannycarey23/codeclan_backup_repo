# Introduction to React - 2. Practice

### Learning Objectives

- Learn to use Create React App
- Create your first React application

## Create React App

When creating a React application we can configure our application manually, setting up our own server, installing React and any other packages we might need to get it up and running. However, Facebook have produced a package called 'Create React App' that allow us to create a boilerplate application with all the build configuration already complete. It comes with a number of useful features already configured:

- A built-in web server
- A build script that includes a pre-configured version of Webpack - webpack is a tool which 'bundles' all our JavaScript code into one single JavaScript file, rather than having to import lots of JavaScript files into our html code.
- The ability to `import` CSS and images
- Hot reloading (Injects changes to your source code into the current state of the page, so we don't need to refresh the browser each time you make a change.)
- Testing - a testing framework that lets us test our app in various ways

...and lots more.

### Creating an Application with Create React App

Let's make use of these great features and create a "Hello World!" application with Create React App.

To use create-react-app to give us a start-point, we can use npx to get a temporary version of create-react-app to use to create the application.

```sh
npx create-react-app hello_world
cd hello_world
npm start
```

> Note: An alternative to using the `npx` prefix would be to globally install create-react-app and then use `create-react-app hello_world`

The `npm start` command has bundled the source code and started the server. It should have also opened the application in a new browser tab going to [http://localhost:3000](http://localhost:3000).

**Once `create-react-app` is finished** we can look at some of the files and directories that it produced and these should look familiar. There is the 'package.json', '.gitignore' and 'node_modules' in the top level directory and there are also the 'public' and 'src' directories. The 'src' directory is where our source code lives, and this is where we will be putting our React components.

## Components

The first component is in App.js which is being rendered to the page by index.js. In most cases we don't edit `index.js`.

Find the `src/App.js`, and delete all the code in it. We'll replace it with the following:

```js
import React from 'react';    // 1️⃣
import './App.css';           // 2️⃣

function App() {              // 3️⃣
  // we can write JS here :)  // 4️⃣
  
  return (                    // 5️⃣
     <h1>Hello World</h1>     // 6️⃣
  );                          // 7️⃣
}                             // 8️⃣

export default App;           // 9️⃣
```


This is a single react component. It's created as a function
If we look at what the component returns from its function 3️⃣, we can see there is some new syntax there 6️⃣. It looks like HTML, but we know that it's not because it is inside a JavaScript file. This syntax is called JSX (which stands for JavaScript XML) and is what we can use in React to describe what we want to be rendered to the page. We are going to be looking more at JSX next. For now let's delete the boilerplate code, so we can write our own.

Looking at this line-by-line:

* 1️⃣ Every React component needs to import the React library. This is true even if you're not explicitly going to use that dependency. (As of React 17 this import is not needed, but you'll see it a lot in legacy code)
* 2️⃣ Each component can have some CSS applied to it for styling - but it's not required
* 3️⃣ The start of a React component - it's just a function
* 4️⃣ The body of the component - the body of the function
* 5️⃣ React components need to return JSX, but often that spans multiple lines
* 6️⃣ JSX of our component - this is the part that's almost identical to HTML
* 7️⃣ The component returning JSX is as simple as `return (*jsx here*);` This is just the closing bracket
* 8️⃣ Closing bracket of the function
* 9️⃣ Export the component so it can be imported and rendered by other components

> ❗️Takeaway points:

We need to remember a couple of very simple things when working with React:

* **React components are functions** but can also be classes (more on classes part later)
* **Every React component must return one of three things: a JSX element, an array of JSX elements or null**. 

If you check the browser, you should now see 'Hello World!' instead of the React logo.

## JSX vs HTML

JSX isn't HTML, but we can use any HTML5 tag as if we were writing plain HTML.

> Add some html inside the return - between the `(` and `)` brackets.


```js
function App() {
  return (
  	<div>
  		<h1 className="title">Hello World!</h1>
  		<p> This is a paragraph of text</p>
  	</div>
    
  );
}
```

Doing this we might come across a restriction in React that says a component can only return a single JSX element. To get round this, we can simply wrap our other components in a `<div>`, or preferably a semantic HTML element.

Note: React and JSX are two independent technologies, but JSX was built with React in mind. Create React App has Babel already configured and Babel is transpiling the JSX into JavaScript, making it compatible with browsers.

## Rendering data

So far we've only seen how to get React to render static data. Our "Hello World" is hardcoded into the JSX - but we need a way to connect our JavaScript code to the JSX that's being used to render to our browser window.

To render data from Javascript variables in JSX all we need to do is wrap them in `{` `}` - it's that easy.

* Add two variables `name` and `age` to the body of the function and give them a value. Remember - our component is just a JS function, and our functions can of course have code in them

* Add a line of JSX that says `<p> My name is {name} and I'm {age} years old</p>`

<details>
  <summary>Solution</summary>

```js
function App() {
  const age = 25;              // ADDED
  const name = "Billy";        // ADDED
  
  return (
   <div>
  	  <h1 className="title">Hello World!</h1>
  	  <p> This is a paragraph of text</p>
  	  <p> My name is {name} and I'm {age} years old</p>
  	</div>  
  );
}
```
</details>


Rendering data in React is really simple because it's just a case of templating the variables that are in our code into JSX with `{}`.

This actually becomes very powerful, as we can use braces ( `{` and `}`) in JSX to actually execute JavaScript code, not just render variables.


### JSX Syntax Highlighting

The JSX syntax highlighting might be broken as it's being interpreted as JavaScript. To fix this you will need to get the Babel package for your editor.

## Conclusion

* **React components are functions** but can also be classes (more on classes as components later)
* **Every React component must return one of three things: a JSX element, an array of JSX elements or null**. 
* **JSX is very similar to HTML, but not exactly the same**
* **Variables within a component can be rendered in JSX with `{ }`**

## Additional Resources

There is also a React implementation for native mobile applications:
[https://facebook.github.io/react-native/](https://facebook.github.io/react-native/)
