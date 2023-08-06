# API calls using Fetch, Promises and Lifecycle Hooks

**Lesson Duration**: 60 minutes

### Learning Objectives

- Understand what a JSON API is and why we use them
- Be able to make a request using `Fetch`
- Understand the relationship between JSON and JavaScript objects
- Be able to traverse a JSON object

## Intro

In this lesson we are going to learn how to request data from an API, so that we can use it in our applications. This can save us a great deal of time, preventing us from having to create the data ourselves.

### What is an API

An API, or application programming interface, is a tool that allows one piece of software to interact with another. A lot of software provides an API, allowing developers to write software that interacts with it. The DOM, for example, is an API. The DOM allows us to write software that interacts with content of a the web page.

As well as providing us with functionality, some APIs simply provide us with data. We can use this data to enhance the functionality of our applications. Modern APIs tend to provide us with data in JSON format. Some older APIs may still use XML, but that's becoming less popular as JSON continues to gain traction. We'll come back to JSON shortly.

### Why Would We Use an API?

APIs often provide us with functionality or data that would be incredibly difficult and time consuming to create on our own.

Let's imagine that you were building a travel app and needed data about all of the countries in the world. You *could* spend time collecting and organising the data yourself, but it would be very time consuming. It would be much more convenient to use an API like [RESTCountries](http://restcountries.eu/) that can provide us with data that someone else has already prepared.

RESTCountries provides us with data about all of the countries in the world in JSON format.

We can see a list of endpoints on their website. An endpoint is essentially a URL that we can make a request to, allowing us to access the API. Let's take a look at the [all](https://restcountries.com/v3.1/all) endpoint. You might install the [JSON Formatter](https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa) Chrome extension to allow the browser to format the data in a more human readable way.

### What is JSON?

JSON, JavaScript Object Notation, is a language agnostic data interchange format derived from JavaScript. It allows us to store data in a human readable format that appears familiar to programmers of C family languages.

When we say that JSON is language agnostic, we mean that it doesn't know anything about any other programming languages. We will be converting JSON to JavaScript today, but we could just as easily make a request from a .NET application, written in C#, and convert the resulting JSON data to C#. This means that we can use JSON as a common language allowing software that was written in different languages to speak to each other.

While JSON may look very familiar, there are a couple of key differences that we must bear in mind. All JSON is valid JavaScript, but not all JavaScript is valid JSON.

1. The keys in a JSON object must be quoted
2. Strings must be declared with double quotes `""`
3. A JSON object cannot contain functions


## The Dog API

Before we dive straight in to wrangling massive data objects, let's work with a smaller response so we can practice making our requests without worrying too much about what we're getting back. [The Dog API](https://dog.ceo/dog-api/) bills itself as _the internet's biggest collection of open source dog pictures_, and has a `random` endpoint that will give us a JSON object containing a URL to an image of a dog. Here's an example response:

```JSON
{
  "status": "success",
  "message": "https://images.dog.ceo/breeds/malinois/n02105162_5370.jpg"
}
```

Before we write any code let's think about what we're about to do.

> Hand out start point

```bash
npm install
npm start
```

### Task - 5 minutes

- Read over the start code to understand what our app is currently doing and come up with suggestions as to how we can approach finishing it.

At the moment, our React instance is set up with a button that will execute `fetchDog` on click, and an `img` in our HTML that will render, dependent on there being a `dogImgURL` in our instance's data. Just now `fetchDog` is just logging out a message when we click it, so all we really need to do here is consider how we're going to get that dog image from our API, retrieve an URL for an image from it and set it to be `dogImgURL`.

So our plan will be something along the lines of:

- We'll make a request to the Dog API
- The Dog API will respond to our request with JSON
- We'll then use the data in our application

And how are we going to our dog data? Appropriately enough, we'll be doing this with another API called `fetch`. But to appreciate what `fetch` does and how it does it, first we'll need to talk a bit about `Promises`.

## Promises

Network requests are asynchronous. This has two major implications.

- They take an unspecified amount of time to complete
- Execution of the rest of our code is not paused in the mean time

We typically create a Promise when we want to retrieve data via some asynchronous operation. This could be requesting data from an API or a database, for example.

Just like a real life promise that represents something that will happen in the future, a JavaScript Promise object represents the result of an asynchronous operation - this can be the completion _or_ failure of the operation. We can write a Promise and then decide what to do once the asynchronous operation has completed. This allows us to pass fewer callbacks around, meaning that our code reads a bit more as if it were synchronous, which can be easier to follow.

### How Does a Promise Work?

When we create a Promise object it will be pending until the asynchronous operation that we are wrapping has completed. Then, just like a real life promise that can be kept or broken, the Promise object will either resolve, if successful, or reject if something goes wrong, allowing us to decide what to do next. We may want to render the data that was received, or perform some kind of error handling if the Promise rejected. We can also chain multiple asynchronous operations by chaining functions which return a Promise.

![A Promise Chain](images/promises.png)

## Fetch

The [`fetch` method](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API) we're going to implement wraps the asynchronous functionality of a request inside a Promise. That means we can write code to handle the result of our request, without having to give too much mind as to when our request is going to finish executing. There are other ways of making network requests but `fetch` is now widely supported across the majority of internet browsers, arguably easier to implement, and in terms of code simpler to read.

So let's try and implement it now! Initially, we'll assign our `fetch` implementation to a variable, so that we can log it out and examine it.

```js
///APP.JS

const fetchDog = function(){
  const request = fetch("https://dog.ceo/api/breeds/image/random")//NEW
  console.log(request);
}
```

In our browser's console, we should now see a pending Promise object, which if examine a bit closer we can see has a `promiseStatus` of `resolved`. Which is good for us, because now we can try and interact with the response the API gave us.  

The primary way of interaction with a Promise is through its _then_ method, which registers callbacks to receive either a promise’s eventual value or the reason why the promise cannot be fulfilled. This allows us to treat a promise like a returned object that we can attach callbacks _to_, instead of passing callbacks _into_ a function, which was previously more commonplace. Let's see _then_ in action.

```js
///APP.JS

const fetchDog = function(){
  fetch("https://dog.ceo/api/breeds/image/random")//MODIFIED
  .then(response => console.log(response)) //NEW
}
```

We can now see the response object that's being logged out - specifically, it's a `Response` object. This contains the JSON body that we're looking for, but to access it we need to call `.json()` on our response. This method also involves some asynchronous operations and therefore returns... another Promise! But that means we can chain another `.then` on to it and continue to work with the response till we have what we want.

```js
///APP.JS

const fetchDog = function(){
  fetch("https://dog.ceo/api/breeds/image/random")
  .then(response => response.json()) //MODIFIED
  .then(data => console.log(data)) //NEW
}
```

And now if we look in our browser's console we should see the response from the API we initially set out to find! Great. So how can we use this data to get the image URL to where we need it to be, in our React data's `dogImgURL`?

### Task - 5 minutes

Take the image URL from our response and set it to be the value of `dogImgURL`.

```js
///APP.JS

const fetchDog = function(){
  fetch("https://dog.ceo/api/breeds/image/random")
  .then(response => response.json())
  .then(data => setDogImgURL(data.message)) //MODIFIED
}
```

And there we go! Now whenever the user clicks the button, we `fetch` request the Dog API, handle the response and then put the URL into our React instance's data, where our data-binding means that it renders automatically. Clicking a button to begin this whole process seems burdensome though - what if we could find a way so that our `fetchDog` function was called as soon as the app loaded, rather than waiting for user input? Well, there is and it utilises React's `useEffect` hook.

At this point it's important to make a distinction - very few APIs behave _exactly_ the same, so it would be wrong to assume that every `fetch` will return an object that we can call `.message` on and expect the data we're looking for. Make sure going forward that you interrogate the data you are retrieving, through an APIs documentation, or even via `console.log` before attempting anything with it.  

## Recap

What are some of the advantages of using a promises when writing asynchronous JavaScript?

<details>
<summary>Answer</summary>
Promises allow us to write asynchronous code that reads as a structured series of events, rather than a series of callbacks, which can be more difficult to follow.
</details>
<br/>
Which method do we call after receiving a `Promise` to determine which behaviour we want to execute it resolves successfully?

<details>
<summary>Answer</summary>
`then`
</details>
<br/>

## Conclusion

Now that we've learned how to use `Promise` objects and the `fetch` web API, we can write asynchronous JavaScript that almost reads as if it were synchronous. Our code appears more like a structured series of events, even if we aren't sure exactly _when_ things will happen. In short, promises allow us to write neater code. `fetch` also abstracts away some of the lower level implementation details of HTTP requests. We don't really have to care exactly how `fetch` is implemented, we just care that we get our data back.

This isn't all that there is to learn about promises, however. Promises really come into their own when it comes to carrying out multiple asynchronous operations either sequentially, using a `then` chain, or at the same time, using `Promise.all`.

We've also looked at how we can lean on React's `lifecycle hooks` to add functionality to our apps with little effort.