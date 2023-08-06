# Advanced Browser Devtools

**Lesson Duration: 20 minutes**

## Learning Objectives

- Be able to display data in the browser's console with `console.log` and `console.table`
- Be able to use Chrome Dev Tools Network to view assets being loaded by a webpage
- Be able to use Chrome Dev Tools Debugger to step through running code

To help us with our JavaScript development, we should familiarise ourselves with some of the more advanced features of the development tools that are built in to our web browser.

## `console`

Let's start by taking a look at the browser's `console`.

We have seen that we can pass more than one argument to `console.log`. The console will concatenate them into a single string, with a space in-between them.

```js
// js/app.js

document.addEventListener("DOMContentLoaded", function() {
	const answer = 1 + 1;
	console.log("The answer is ", answer);
});
```

We can also format arrays and objects nicely, using `console.table()`.

```js
// js/app.js

document.addEventListener("DOMContentLoaded", function() {
	// ...
	const fruits = ["apple", "orange", "banana"];
	console.table(fruits);

	const person = {
		name: "Jane",
		age: 40
	};
	console.table(person);
});
```

## Breakpoints

While `console.log`ing information can be useful, it is often preferable to be able to step through our code line-by-line, checking the state of the program along the way.

We can also use our developer tools as a debugger, just as we've done in other programming languages.

Let's say that we have some complex logic we want to step through:

```js
// js/app.js

document.addEventListener("DOMContentLoaded", function(){
	// ...
	let number1 = 5;
	number1 += 10;
	const number2 = 20 + number1;
	const number3 = number2 / 10;
});
```

We can step through this program line by line, by using the `debugger` statement.

```js
// js/app.js

document.addEventListener("DOMContentLoaded", function(){
	// ...
	debugger; // Added
	let number1 = 5;
	number1 += 10;
	const number2 = 20 + number1;
	const number3 = number2 / 10;
});
```

Now, when the program executes, we should see the browser window appear to "freeze" when it hits the `debugger;` line.

![Breakpoints](./images/breakpoints.png)

We can use the arrows to step through our code line by line. Notice that the values of the variables in the Scope pane change as we step through. We can also execute code in the console, and when we do, we'll have access to the same variables that we would have at that point in our program.

## DOM Breakpoints

Sometimes, it can be hard to tell _what_ is modifying the DOM, especially as our programs grow in size. We can set DOM breakpoints to give us more information about why the DOM is changing.

Let's set a DOM breakpoint by right-clicking the `<body>` tag within our devtools. Next, we're going to select "Break on..." > "Attribute Modifications".

Now, we're going to add the following code to our JavaScript file. This should add a new class to the `<body>` tag after three seconds:

```js
// js/app.js

document.addEventListener("DOMContentLoaded", function() {
	// ...
	setTimeout(function(){
		document.body.classList.add("lightblue");
	}, 3000);
});
```

When this code is about to execute, the breakpoint kicks in, allowing us to tell what's going on inside our programs. We can also break when the element's children would be added, changed, or removed ("subtree modification"), or when the element itself would be removed ("node removal").

To remove a DOM breakpoint, right-click on the same element, and remove the breakpoint you set.

## Network Tab

Finally, let's look at another developer tool that can be useful when we're debugging problems, the Network tab. The Network tab displays information about all of the resources that our page needs to display itself.

## Loaded Resources
We can see information about all the individual requests and responses for our images, CSS, and JavaScript files, among others.

In the Network tab we can see that index.html, app.js and style.css. If we commented out the `<script>` tag that loads app.js in index.html, the JavaScript wouldn't be run.

```HTML
<!-- index.html  -->

<!-- ... -->
<!-- <script src="js/app.js"></script>  --> <!-- MODIFIED -->

```

We can filter the type of request by clicking on the relevant tab or typing in the 'filter' field.

This tab can be really helpful to diagnose whether files are loading or not. For example, if you aren't seeing any styles applied, you can check to make sure that the response code for your stylesheet is `200`, as it should be. If there is a problem with one of your files, it should be highlighted in red.

Notice that we can click on any individual request to get more information about it, or the related response.

### Further Resources

- [Chrome Devtools Overview](https://developer.chrome.com/devtools)
- [Video: debugging using devtools](https://developers.google.com/web/tools/chrome-devtools/javascript/)

### Conclusion

We have learnt a number of debugging tools including:

- Outputting data to the browser console with `console.log` and `console.table`
- Chrome Dev Tools, which give us a range of debugging tools, such as breakpoints
- the network tab,  where we can view more information about requests and loaded files
