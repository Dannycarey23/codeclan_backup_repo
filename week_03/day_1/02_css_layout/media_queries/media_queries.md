# Media Queries

### Learning Objectives

- Know what responsive design is
- Know what mobile first design is
- Be able to use media queries to apply styling rules based on screen size

## Introduction

When designing websites it's important to remember that different people will be viewing your website on different devices. For this reason, it's important that your website looks good on many different screen sizes. Creating a web page that changes in response to the user's screen size, platform and orientation that it is being viewed in is known as responsive design.

As of 2017, more than 50% of web traffic comes from mobile devices. This has lead to a rise in what is known as mobile first design. As the name suggest, mobile first design has us design the mobile version of our website first and layer changes for larger screen sizes on top of this mobile layout.

Media queries allow us to apply styling rules based on the screen size of our user. In this lesson we will take the blog site that we created the other day and use media queries to make it look great on various screen sizes.

Open up the start code and take a few minutes to reacquaint yourself with the structure of the HTML and see how it is being styled.

## The Plan

Open index.html with Google Chrome, open the devtools and toggle the device toolbar. At the top of the screen, select a mobile phone. This will allow us to view our site as if we were viewing it on a specific mobile device. The layout looks great at this size, but as we increase the screen size it quickly starts to look worse. Clicking through the various sizes will allow us to see this.

We're going to apply a set of styling rules that will come into effect as we increase the size of our screen, so that our web page looks consistently awesome on any device.

When viewed on a tablet we want:

- the main content to have a bit more horizontal padding
- the author information to become a row, instead of a column
- the footer to become a row, instead of a column

When viewed on desktop we want:

- the header to become a row, instead of a column
- the side menu to be displayed on the side of the page

## Lesson Content

Our CSS file is starting to get a little on the hefty side. We don't want to add any more CSS to the same file, so it would probably be wise to create some new files for our responsive design.

```bs
touch tablet.css
touch desktop.css
```

Now that we have created more CSS files, we'll need to reference them in our HTML with `<link>` tags, so that they load when the browser loads the page.

```html
<!-- index.html -->

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="tablet.css">  <!-- NEW -->
  <link rel="stylesheet" href="desktop.css"> <!-- NEW -->
  <title>CodeClan Blog Site</title>
</head>
```

For the purposes of this lesson, we're going to keep it super simple and use 720p for tablets and 1080p for desktop. In reality, there are a whole host of different standard screen sizes that should be accomodated for.

We'll start with our tablet layout, as that's the next size up from mobile. To begin with, let's just change the background colour so that we can tell if our code is working.

```css
/* tablet.css */

@media (min-width: 720px) {
  body {
    background-color: hotpink;
  }
}
```

This says that if the user's screen size is greater than 720 pixels wide, then we should apply all of the styling rules enclosed in the media query. If the styling rules are applied then the background colour of everything within the body will change to hotpink.

You can think of this like an `if` statement in Python.

```py
# Example

if screen_size >= 720:
    body.background_color = "hotpink"
```

You should now see that while viewing our page in a size smaller than 720 pixels wide, the background colour is white. Once we move up to a wideness greater than 720 pixels, the background colour should change to hotpink.

Now that we know that our media query is working, let's apply the changes that we actually wanted to make for tablet.

```css
@media (min-width: 720px) {
  #footer-container {           /* NEW */
    flex-direction: row;        /* NEW */
  }                             /* NEW */

  #footer-container > section { /* NEW */
    margin-right: 32px;         /* NEW */
  }                             /* NEW */
}
```

The footer will now first receive the styling defined in style.css, then if the user's screen size is greater than 720 pixels those rules will be overwritten by the above.

Refresh the page and try viewing the site at different screen sizes. You should notice that the footer will change between being displayed as a column or row.

We also added some margin to the sections, so that they won't appear right next to each other.

Next, we will apply some rules to the footer of the article. We want the author section to become formatted as a row on larger screen sizes.

```css
@media (min-width: 720px) {
  body > main > article > footer {       /* NEW */
    flex-direction: row;                 /* NEW */
  }                                      /* NEW */

  body > main > article > footer > img { /* NEW */
    margin-right: 16px;                  /* NEW */
  }                                      /* NEW */

  #footer-container {
    flex-direction: row;
  }

  #footer-container > section {
    margin-right: 32px;
  }
}
```

Again, we also added a small amount of margin to the right of the image, so that the text doesn't appear right up against it.

Lastly, we will reduce the width of the main section, so that the text doesn't extend as far towards the edges of the screen. This will make our text a little bit easier to read on wider screens.

```css
@media (min-width: 720px) {
  body > main { /* NEW */
    width: 70%; /* NEW */
  }             /* NEW */

  body > main > article > footer {
    flex-direction: row;
  }

  body > main > article > footer > img {
    margin-right: 16px;
  }

  #footer-container {
    flex-direction: row;
  }

  #footer-container > section {
    margin-right: 32px;
  }
}
```

Excellent. That's all of the changes that we wanted to make for tablets completed. Next we will move on to the desktop layout for the site.

Again, we will begin by simply changing the background colour when the device size is greater than the size that we define, just to check that everything is working correctly.

```css
/* desktop.css */

@media (min-width: 1080px) {
  body {
    background-color: hotpink;
  }
}
```

Test this out by changing the device size to something wider than 1080 pixels in Chrome. You should see that the background colour changes to hotpink.

Now that we know that everything is working, we will start by modifying the header. When the page is viewed on a large device, we want the header to be formatted as a row, rather than a column.

We will also need to specify that the ul should be vertically aligned in the centre of the header.

```css
@media (min-width: 1080px) {
  body > header {            /* NEW */
    flex-direction: row;     /* NEW */
  }                          /* NEW */

  body > header > nav > ul { /* NEW */
    align-items: center;     /* NEW */
  }                          /* NEW */
}
```

Lastly, we want the main article and the side menu to be formatted as a row, rather than a column.

```css
@media (min-width: 1080px) {
  body > header {
    flex-direction: row;
  }

  body > header > nav > ul {
    align-items: center;
  }

  body > main {           /* NEW */
    flex-direction: row;  /* NEW */
  }                       /* NEW */

  body > main > article { /* NEW */
    padding: 0 100px;     /* NEW */
  }                       /* NEW */
}
```

Again, we're using a bit of padding on the main article, so that the text doesn't extend as close to the edge of the screen. This also gives better separation between the article and side menu.

## Recap

What is responsive design?

<details>
<summary>
Answer
</summary>

Responsive design states that our design should respond to the user's screen size, platform and orientation.
</details>

What name is given to the idea that we should create the mobile layout of our web page before the desktop version?

<details>
<summary>
Answer
</summary>

Mobile first design
</details>

## Conclusion

In this lesson we learned how to apply styling rules conditionally, based on the screen size of the user. This allows us to ensure that our web pages look good when viewed on a number of different devices.

We could also use media queries to specify different layouts for if our page were to be printed or interpreted by a screen reader. You can find more information on how to do these things in the additional resources section below if this interests you.

## Additional Resources

- [MDN - Using media queries](https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries/Using_media_queries)
- [CSS-Tricks - Media Queries for Standard Devices](https://css-tricks.com/snippets/css/media-queries-for-standard-devices/)