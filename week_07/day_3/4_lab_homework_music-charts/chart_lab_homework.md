# Lab and Homework

## Learning objectives
- Practise making a request in a React app and passing the data from that request down the chain of components

## Task

Make a simple React app that displays the current UK top 20 songs. You can get the data for this here:

https://itunes.apple.com/gb/rss/topsongs/limit=20/json


The MVP is to request the data, then display the list of songs with each song showing its chart position, title and artist. 

## Extensions
Add more information - you could include images or the preview song audio clips. Style this nicely with CSS.

AND/OR

The iTunes API can also return "charts" based on specific genres (see the below table). Add a dropdown so the user choose a genre of music to display!

| Genre       | Endpoint                                                          |
|-------------|-------------------------------------------------------------------|
| All         | https://itunes.apple.com/gb/rss/topsongs/limit=20/json            |
| Rock        | https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=21/json   |
| Dance       | https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=17/json   |
| Country     | https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=6/json    |

```
{name: "All", url: "https://itunes.apple.com/gb/rss/topsongs/limit=20/json"},
{name: "Rock", url: "https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=21/json"},
{name: "Dance", url: "https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=17/json"},
{name: "Country", url: "https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=6/json"}
```    
