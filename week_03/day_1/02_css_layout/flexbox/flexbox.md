# Flexbox

__Lesson Duration: 30 minutes__

### Learning Objectives

- Understand the purpose of Flexbox
- Be able to use Flexbox to control the layout of elements within a container

## Introduction

CSS is used to control the aesthetics of a website. We've seen that CSS can be used to change the appearance of text and other elements on a page. CSS can also be used to control the layout of a page, deciding how elements should be positioned in relation to one another. In this lesson we will learn how to use Flexbox to organise child elements into rows or columns within a parent container element. This could be useful for positioning navigation links within a header, for example, or images within an image gallery.

Open the start code with your text editor and take a moment to think about the structure of the HTML and the styling that is being applied to the elements. Then open index.html with your web browser. You'll notice that some of the basic styling has been done for us, background colours have been added to the header and footer, the bullet points have been removed from the unordered lists, etc. but none of the elements are positioned in the way that we want them to be. We'll use flexbox to fix that.

## Properties

Flexbox provides us with two sets of properties that can be used to control the layout of our elements. One set that should be applied to the parent element and another that should be applied to the child elements within the parent. [CSS Tricks](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) offer a fantastic Flexbox resource, describing and illustrating exactly what effects each of these properties can have on the layout of our elements. Throughout this lesson, we will refer to this article, so it might be a good idea to keep it open.

## Styling our Website

Let's start at the top of the page and work our way down. We'll begin with the header. Ideally, we would like the name of the website to be displayed on the left and the navigation links to be displayed on the right. Flexbox makes this simple.

To enable Flexbox, we need to set the `display` property of the parent element to `flex`. In this case, the parent element is the header element that's a direct descendant of the body, so we can add this to the existing styling rules for that element in the style.css.

```css
/* style.css */

body>header {
    padding: 1rem;
    background: dodgerblue;
    display: flex; /* NEW */
}
```

If you refresh the page, you should see that Flexbox has moved the child elements of the header into a row. The navigation links now sit next to the name of the website instead of under it. This isn't exactly what we're looking for, but it's a good start. Next, we want to control how the child elements are positioned within the parent element. We're looking for the name of the website to be pushed all the way to the left, while the navigation links are pushed all the way to the right.

We can use the `justify-content` property of a flex container to control how the elements within it are positioned.

### Question

- Referring to the [CSS Tricks](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) article, which value do you think we should use for `justify-content` to create as much space as possible between the elements in our flex container?

<details>
<summary>Answer</summary>

```
justify-content: space-between;
```
</details>

Let's try it out.

```css
body>header {
    padding: 1rem;
    background: dodgerblue;
    display: flex;
    justify-content: space-between; /* NEW */
}
```

Now the name of our website should be displaying on the left side of the header, while the navigation links are on the right. It isn't quite there yet but it's already starting to look much better. Next, we might want to use Flexbox to have our navigation links be displayed in a row, rather than a column. To do this, we will have to apply `flex` to the parent element (the `ul` that lives inside of the `nav`, which is inside of the `header`).

There's already a styling rule to remove the padding from this element in style.css, so we can just add more rules there.

```css
header>nav>ul {
    padding: 0;
    display: flex; /* NEW */
}
```

Now the navigation links are sitting nicely in a row, but they're all squished up against each other. Luckily, Flexbox gives us a handy `gap` property that we can use to create a gap between the child elements. Let's add a `gap` of 1rem.

```css
header>nav>ul {
    padding: 0;
    display: flex;
    gap: 1rem; /* NEW */
}
```

Now the header is looking much better. The only problem left to solve is that the navigation links are sitting higher up than the name of the website, making it look a bit off.

### Question

- Referring back to the [CSS Tricks](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) article, which property and value do you think we could use to control the vertical alignment of the child elements of our row?

<details>
<summary>Answer</summary>

```
align-items: center;
```
</details>

Let's try it out.

```css
body>header {
    padding: 1rem;
    background: dodgerblue;
    display: flex;
    justify-content: space-between;
    align-items: center; /* NEW */
}
```

### `justify-content` vs. `align-items`

Flexbox is best used for 1-dimensional layouts when we want items to be distributed in either a row or column. When we're working with a row, `justify-content` can be used to control how the child elements are distributed within the row. Are they pushed as far apart as possible within the row like our website name and navigation links, or do they sit close to each other like the navigation links? `align-items` is used to position elements on the opposite axis to `justify-content`. When working with a row, `align-items` allows us to control where the child elements will sit vertically within the row. When working with a column, `align-items` could be used to control whether the column is left, middle or right aligned. These are two of the most important Flexbox properties and learning to use them well can make positioning elements with CSS a lot easier.

Next, let's work on the author section of the page. We want the author's details to appear on the same line as the image instead of under it.

The HTML for this section of the page appears as follows:

```html
<footer id="author">
    <img src="https://i.imgur.com/sOUgMbE.jpg" alt="A. Cat">
    <section>
        <h2>Author: A. Cat Jr.</h2>
        <h3>Last posted: 28/05/2022</h3>
        <a href="https://codeclan.com">https://codeclan.com</a>
    </section>
</footer>
```

The footer with the id `#author` has 2 child elements, the image and a `section` containing the author information. This means that we can use Flexbox on the footer to have these 2 elements display in a row. We'll also add a `gap` again, so the elements aren't squashed up against each other.

```css
#author {
    padding: 1rem;
    border: 2px dashed #eee;
    display: flex; /* NEW */
    gap: 1rem;     /* NEW */
}
```

We could also use Flexbox to have the filters appear on the right side of the page, next to the main article but there's a better tool for that job which we will learn later. We'll skip that for now and just use Flexbox to style the page footer to finish off.

### Task

We would like for the our site and important files sections to appear next to each other in a row. The HTML for this section of the page appears as follows:

```html
<div id="footer-container">
    <section>
        <h2>Our Site</h2>
        <!-- ... -->
    </section>
    <section>
        <h2>Important Files</h2>
        <!-- ... -->
    </section>
</div>
```

The `div` with the id `#footer-container` has 2 child elements. Use Flexbox to have these `sections` display in a row. You may want to add a `gap` or use another property to control how the child elements are distributed.

<details>
<summary>Example Solution</summary>

```css
#footer-container {
    display: flex;
    gap: 2rem;
}
```
</details>

# Conclusion

In this lesson, we saw that Flexbox can be a handy tool for positioning elements into 1-dimensional rows or columns. We looked at some of the most important `flex` properties but there are many more that can be useful when creating more complex layouts.

The [CSS Tricks](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) article that we referred to throughout this lesson is a very useful resource when using Flexbox. It can be a good idea to refer to while styling your websites to help visualise how the layout that you're trying to create translates to Flexbox properties. It's definitely worth a bookmark.
