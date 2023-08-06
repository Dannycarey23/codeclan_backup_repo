## Learning Objectives
 - Know the benefits of React Router
 - Be able to use React Router in a simple application

## Introduction
Traditional server rendered applications work by entering the URL into the browser address bar, making a new request for each page. Traditionally, each page  was normally actually a file or folder that's hosted on the web-server. So if we went to `mysite.com/about` on a site running an older server, it would actually look in the `./about` directory for an `index.html` page, and return that to the browser. This means that the information being displayed and the URL are kept in sync.

 Single-Page Applications are only actually loaded from one single html file. This makes navigation difficult. Browser navigation buttons don't work, and we can't direct users directly to specific pages of the app. React has a router module which will help us out with this. It allows us to create a Single-Page application where the UI and URL will be kept in sync so we can use the Browser Navigation features.


### Setup

Let's set up an application.

 > Instructor note: Hand out the router start point

This is a simple application that does nothing rendering a title. Looking around, there are more components in the `components` directory.


# Why Router
We have About, Home and Pricing components. We would like each of them to appear to be accessible through browser based routing. This means we would like to go to `localhost:3000/about` and see the About component; go to `localhost:3000/home` to see Home and `localhost:3000/pricing` to show Pricing.

**How can we do this, if react is designed to offer graphical interfaces as a "single page"?**  
  
Enter the need for a router. React router is a library for allowing us to create fake routes or pages on our application, and assign a component to them.

> Does that mean that we want all of our components to be attached to one of these components?

**No. In a typical react app there might be tens or even hundreds of components, but we only want to attach routes to the ones that we want to use as our main "pages" or "views" of the application**

# Adding Router

It's a library that's not built into the react library, so we need to install it through NPM.

```
  npm install react-router-dom
```

Let's set up the `App` component to work as router. We will import our other components so we can later pass them in our routes. We will also import `BrowserRouter` (which we rename `Router` for convenience) from the `react-router-dom` library.

```js
// src/App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; //NEW
import About from "./components/About"; //NEW
import Home from "./components/Home";  //NEW
import Pricing from "./components/Pricing";   //NEW

```

And we use this `Router` component in our `render` method:

```js
// /src/App.js
return (
	<Router>
	
	</Router>
);

```

`Router` will keep track of our navigation through our entire React application. This means now when we refresh it will remember where we were and we can use our browser navigation buttons to go back and forth through our browsing history. We want to bring in the `<Router>` component pretty high up in the tree.

Now we are going to define our routes inside `Router`. We have to wrap them in the (`<Routes>` / `</Routes>`) component because `BrowserRouter` only expects one element. Each `Route` takes two attributes, a path and an element (component) to render on that path.

```js
// /src/App.js
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // UPDATED

const App = () => {


  // AS BEFORE

return (
  <Router>
    <Routes>
      <Route path="/" element={< Home />} />
      <Route path="/about" element={< About />} />
      <Route path="/pricing" element={< Pricing />} />
    </Routes>
  </Router>
);
}

```

Think of using the `<Router>` and `<Route>` components like creating an index for a book. The `<Router>` says we're going to create an index page, and a `<Route>` specifies an individual entry into the index.

**Note `<Router>`, `<Routes>` or `<Route>` are not components which we will be able to *see* rendered in our application - as they are acting as placeholders**. These placeholders tap into the the page that we ask our browser to navigate to, and only when we navigate to a page which has a `<Route>` registered for it, it will render that component.


## Navigation

We can now check the routes we created by visiting them in our browser:

* http://localhost:3000/
* http://localhost:3000/about
* http://localhost:3000/pricing

But typing addresses into the browser is no good. Our app needs a navbar!

```bash
touch src/components/NavBar.js
```

We will render this NavBar above our routes definition. It will need to go inside the `<Router>` above our `<Routes>` to be rendered properly. 

```js
// /src/App.js
import NavBar from "./components/NavBar";

 <Router>
  <NavBar /> // ADDED

  <Routes>
    {/* Routes as before */}
  </ Routes>

</Router>
```

Our `NavBar` is going to consist of an unordered list of links. In HTML, we would use `a` tags for links, with `href` attributes that point to a URL. React Router has a built-in `Link` component, which has a `to` attribute to point to its routes. This makes for some really cute code:

```js
// /src/components/NavBar.jsx
import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {

  return (
    <ul>
      <li>
        <Link to="/">Home</Link>
      </li>
      <li>
        <Link to="/about">About</Link>
      </li>
      <li>
        <Link to="/pricing">Pricing</Link>
      </li>
    </ul>
  );
}

export default NavBar;
```

We can see as we navigate through the site, and the URL changes. So our browser's back button works as we'd expect, and we can bookmark pages in our app.

### Task: (5 minutes)

Create a new component and add it to the list of links in the Main component.

## Passing down props

Loading our components in this way, we just pass the component to a `Route` and React Router knows what to do. It knows how to render it, and when. But what if we also wanted to pass props to a component that we have set up a route for? Often there is no need to do that; our routes point to top-level components, which act like separate pages and don't need to take in props. But sometimes we _do_ need to pass props down, and luckily React Router has a very nice and simple syntax for this.

Let's say we wanted to pass some actual pricing data to our `Pricing` page component. Maybe in the real world this data might come from our server, but for now we'll just hard-code it in our `Main` component's state:

```js
// /src/App.js
import React, { useState } from 'react';  // MODIFIED

//as before

const App = () =>{
let initialPricing = [
    { level: "Hobby", cost: 0 },
    { level: "Startup", cost: 10 },
    { level: "Enterprise", cost: 100 }
  ];
  
  const [pricing, setPricing] = useState(initialPricing);
  
  //as before
}
```

As we're passing our `Pricing` component into a `Route` through the `Route`'s `element` attribute, all we need to do is also give it the props that it will need, just like we have been doing it so far when rendering React components:

```js
// App.js

      <Route   // UPDATED HERE
        path="/pricing"
        element={ <Pricing prices={pricing} />}
      />
   
```

We can check this out in React dev tools and see that when the `Pricing` component mounts at http://localhost:3000/pricing it gets passed an array of 3 prices as props.

We can make use of these props to render a price list:

```js
// /src/components/Pricing.js

const Pricing = ({prices}) => { // UPDATED

  const listItems = prices.map((price, index) => { // NEW
    return <li key={index}>{price.level}: £{price.cost} per month</li>
  })

  return (
    <div>
      <h4>Pricing</h4>
      <ul>
        { listItems } // UPDATED
      </ul>
    </div>
  )
};
```

## Default Route

Lastly, let's look at what would happen if we wanted to add a default component that renders in the event of a user trying to hit a route that we haven't defined. Let's create an `ErrorPage` component.

```bash
touch src/components/ErrorPage.js
```

```js
// /src/components/ErrorPage.js
import React from "react";

const ErrorPage = ()=> (
  <h1>404 - PAGE NOT FOUND</h1>
)

export default ErrorPage

```

And then let's implement it in our Router:

To do this we will create a new route and set the path to be `*`. This signifies that this route will only be reached if there are no other matching routes for where the user is trying to navigate to. 

```js
// /src/App.js

import ErrorPage from './components/ErrorPage' //NEW

<Router>
  <>
    <NavBar />
    <Route exact path="/" element={< Home />} />
    <Route path="/about" element={< About />} />
    <Route 
        path="/pricing"
        element={ <Pricing prices={pricing} />}
      />
    <Route path="*" element={< ErrorPage />} /> //NEW
  </>
</Router>

```


Now if we check back, everything should be working as expected. `"/"`, `"/about"`, `"/pricing"` all display their respective components, and any other path we type into our browser address bar will give us our `ErrorPage` component.

### Path parameters

Next we will look at what happens if there are parameters in our paths. This might happen if you wanted to look at individual items in a database using the id, for example. So may want to go to `http://localhost:3000/tasks/1` or `http://localhost:3000/tasks/2`, etc.

To include path parameters in our routes we use the syntax `:nameOfparameter` in our route. 

Let's create a new route that takes in a path parameter. We can call this anything we want. In this case let's create a Choice component and display the choice that has been entered into the path. 

```bash
touch src/components/Choice.js
```

```js
// Choice.js

import React from 'react';

const Choice = () =>{
   

    return (
        <>
            <h1>Choice </h1>
            <p>You're on page </p>
        </>
    )
}

export default Choice;
```

Lets code up the route for this. We will call our path parameter `:choice`.

```js
// App.js

// AS BEFORE
import ErrorPage from "./components/ErrorPage";
import Choice from './components/Choice'; // ADDED

const App = () => {


  <Routes>
       
        <Route path="/choices/:choice" element={< Choice />} /> // ADDED
        <Route path="*" element={< ErrorPage />}/>
  </Routes>

}
```

Now if we go to a route like `http://localhost:3000/choices/banana` we should see the choices page. We need access to that choice we have entered into the path though. (In this case `banana`).

To get access to this we can use a hook from the router called `useParams`.

Let's import this in to Choice.js

```js
// Choice.js

import React from 'react';
import {useParams} from 'react-router-dom';

const Choice = () =>{


    return (
        <>
            <h1>Choice </h1>
            <p>You're on page </p>
        </>
    )
}

export default Choice;
```

And we will call useParamas function at the top of the component. This will bring us an object back with keys matching the name of the path parameter we defined in the Route and a value matching what has been typed into url bar. In our case `{choice: 'banana'}`. We will assign this to a variable and use that in our JSX. We will destructure just to get the choice property back.

```js
// Choice.js

import React from 'react';
import {useParams} from 'react-router-dom';

const Choice = () =>{

  const {choice} = useParams()

    return (
        <>
            <h1>Choice {chocie}</h1>
            <p>You're on page {choice}</p>
        </>
    )
}
```

Awesome we can now see whenever we go to `/choice/something` we can see the parameter displayed on the Choice page. 
 

## Summary

In this lesson we've seen how React Router enables our users to use standard browser features like a Back button and bookmarks, by matching our UI to appropriate URLs. We can set up `Routes` within a `Router` component, match them to specific URL paths, and load components when the browser requests those routes. We can also pass properties into the components that React Router loads. We have also seen how to use the `Link` component in place of `a` tags to take advantage of React Router's features, and how we can use `Switch` to ensure more control over what components are rendering dependent on the URL path.

### Useful resources

* [React Router Tutorial](https://github.com/remix-run/react-router/blob/main/docs/getting-started/tutorial.md)
* [React Router Website - reactrouter.com](https://reactrouter.com)
