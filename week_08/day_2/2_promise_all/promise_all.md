# Requests - Promise.all()

## Learning Objectives

- Understand how to make several requests using Promise.all()

## Duration
45 minutes.

# Intro

> Open the promise_all_start code in VS Code, `npm install` and `npm start`.

If we look at the app we made using the Rick and Morty API we were able to make a request to get all of the characters data. When we got that data each character had an array with links to the episodes that they appeared in. These links are further API endpoints. If we wanted to get the relevant episode data we would need to make more requests to the API to fetch these.  This can cause us some issues as we may not know how many calls to make, each call will take some time and some may take longer than others so we may not get data back in same order each time.

We know that each fetch request returns a Promise.

As these requests all take time we can make sure that all of these will resolve in succession before we move on. To do this we can use the `Promise.all()` method.

## Making further requests

`Promise.all` takes in an array of promises. In our case it will be the promises returned from getting the JSON from our fetch requests. We can then execute all of the promises in turn and return an array with arrays of the result of each promise. Seems confusing but if we use our Dev tools and console logs we should be able to see what is going on here.

First thing to think about is where do we want these requests to take place?

A good to handle this though would be in the `handelSelectChange` function. We can add state to store the episodes and then populate that when a character is selected The reason for this is we want to make sure we only have data that is relevant and useful in our components.

Let's add the state to the comonent first: 

```js
// MainContainer.js

 const [ characters, setCharacters ] = useState( [] )
    const [ selectedCharacter, setSelectedCharacter ] = useState( null )
    const [episodes, setEpisodes] = useState([]) // ADDED

```

Let's add this to the `handleSelectChange` funnction so we have it triggered when the selected character object is available. 


In `handleSelectChange` we can use the map function on the array and return an array of promises to fetch each episode. And we will log out what we get back.


```js
// MainContainer.js


  const handleSelectChange = (character) => {
    const episodePromises = character.episode.map((episode) => {
      return fetch(episode).then(res => res.json());
    })
    console.log(episodePromises); //ADDED
  }

  setSelectedCharacter(character);
}
```

And we will call this method in our `handleSelectedCharacter` function.


So if we select a character and look at our console we should see that we get an array of promises.

What we want to do is to execute all of those promises and wait until these are complete before trying to use the data.

We will use `Promise.all` for this.

### Promise.all

`Promise.all` takes in an array of promises and returns us another promise once all of the promises in the array have been resolved. Once this happens we can use `.then()` to see our data.

```js
// MainContainer.js

  handleSelectChange(){
  const episodePromises = character.episode.map((episode) => {
    return fetch(episode).then(res => res.json());
  })

  Promise.all(episodePromises)
  .then((data) => {
    console.log(data);
  }) //ADDED

  setSelectedCharacter(character);
}
```

So now we should see an array all of the episodes that character has appeared in. Awesome!

We can now set the episodes state. We will also need to move our call to `setSelectedCharacter` as well.

```js
// MainContainer.js

getEpisodes(){
  const episodePromises = character.episode.map((episode) => {
    return fetch(episode).then(res => res.json());
  })

  Promise.all(episodePromises)
  .then((data) => {
    setEpisodes(data)
    setSelectedCharacter(character); // MODIFIED
  })
}
```

Lastly we will pass episodes in as a prop to `CharacterDetail`


```js
// MainContainer
<div>
            <h1>Characters</h1>
            <CharacterSelect characters={ characters } handleSelectChange={ handleSelectChange } />
            { selectedCharacter ? <CharacterDetail character={ selectedCharacter } episodes={episodes} /> : null } // MODIFIED 
        </div>

```

If we go to the browser now and have a look at the React Dev tools once we select a character we should now see the episodes passed in as props to character detail as well. 


### Rendering the episodes

If you look at the components folder we have coded a couple of new components to display the episode names in a list.

We have a component called `EpisodeList` and this renders a list of `EpisodeListItem` components.

Let's now render out `EpisodeList` in the `CharacterDetail` component. Into this component we will pass the episodes.

Let's start by destructuring episodes form the props

```js
// CharacterDetail.js

const CharacterDetail = ({character, episodes}) => { // MODIFIED

// AS BEFORE

}

```

There is already a `div` here to add styling.

```js
// CharacterDetail.js 

 <div id="episode-list-wrapper">
      <EpisodeList episodes={episodes} /> //ADDED
    </div>
  </div>
```

And import the file and register the component.

```js
// CharacterDetail.js
import react from 'react';
import './CharacterDetail.css'
import EpisodeList from './EpisodeList'; // ADDED

```

And now if we look at our app we should see a list of the episodes on the right hand side.

Awesome!

# Conclusion

When we need to make several requests to different end points of an API the best use is Promise.all()

This ensures that all our requests resolve before attempting to use the data and they resolve in the order that we pass them into the array of promises.

# Summary
- Learned how to use promise.all() to make several requests to an API.
