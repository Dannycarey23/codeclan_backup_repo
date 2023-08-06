# Using the Countries API with React

### Learning Objectives
- Understand how to pass data between components

##  Intro

We've seen how to pass data down to child components and how to pass data back up by passing in functions as props. Let's put all of that together to work with an API.

### Task: 10 minutes

Read though the code and identify how the data is flowing throughout the application - for instance, where is the Country data coming from? Where does that data then go, in terms of components and how does it get where it's going?

<details>
<summary>Answer</summary>

- On mount, `CountriesContainer.js` makes a `fetch` request to the REST Countries API and sets the result of that to be the `countries` data field.
- The countries data is passed down to the `CountryList` component as `props`. This is a `ul` and for each `country` in the array of `countries` that have been passed down as props a `ListItem` component is rendered.
- The `ListItem` has `props` of `country`.  This component is rendering the country's name as an `li`
</details>


**What are we building?**

All we have is a list of names of Countries. But if we look at the [API](https://restcountries.com/v3.1/all) you can see that it gives us a lot more information.

We want to be able to click on a list item and have details of that country render on screen. To do this we'll pass a function down to ListItem to be invoked on click of a country.

First we'll add an event handler to our ListItem component. Remember we haven't written `onCountryClicked` yet!

```js
// ListItem.js

const ListItem = ({country, onCountryClicked}) => {

  const handleClick = function() {
    console.log(`Clicked on ${country.name.common}`);
    onCountryClicked(country);
  }

  return (
    <li onClick={handleClick}>{country.name.common}</li>
  )
}

export default ListItem;

```

## Listening for the Event

Within `CountriesContainer.js` we can see that we have a data value of `selectedCountry` which is initially set as `null`. We want to set that value to be the data of the list item we've clicked on.

Let's start off by writing the function that takes in the clicked country and sets the `selectedCountry` state in this component. We also need to tell the container that it will have a `country` property

```js
// CountriesContainer.js

    // ... AS BEFORE

    //-------------- NEW FUNCTION
    const onCountryClicked = function(country) {
        setSelectedCountry(country);
    }
     //--------------------------

    return (
        <div className="main-container">
            <CountryList countries={countries} onCountryClicked={onCountryClicked}/>
        </div>
    )
```

Then pass it down the tree to the `ListItem`

```js
// CountryList.js

const CountryList = ({countries, onCountryClicked}) => {

    const countryItems = countries.map((country, index) => {
      return <ListItem country={country} key={index} onCountryClicked={onCountryClicked}/>
    })

    // ... as before

```

Navigate to the browser and click on a country in the list.  Then within your dev tools change back to component view and select the `CountryContainer` component. 

We've now successfully managed to pass data from one component to another. From here we can use this data to render details about the selected country.

## Rendering Country Detail

Let's make a new component which is responsible for rendering the Country detail.

```bash
touch src/components/CountryDetail.js
```

```js
// CountryDetail.js

const CountryDetail = ({country}) => {

    return (
      <div className="country-detail">
        The capital of {country.name.common} is {country.capital}
      </div>
    )
  }
  
  export default CountryDetail;
```

Now we need to think about where we want this component to be rendered? We'll do it within the `CountriesContainer` component as we ned to pass the selected country down from the state.

```js
// CountriesContainer.js

    return (
        <div className="main-container">
            <CountryList countries={countries} onCountryClicked={onCountryClicked}/>
            <CountryDetail country={selectedCountry}/> 
        </div>
    )
```

Navigate back to the browser and refresh the page. The list no longer renders and there's an error in the browser.

```
cannot read property name of null
```

We can use a ternary to get round this problem.


```js
// CountriesContainer.js

    return (
        <div className="main-container">
            <CountryList countries={countries} onCountryClicked={onCountryClicked}/> 
            {selectedCountry ? <CountryDetail country={selectedCountry}/> : null}
        </div>
    )
```

### Mini-Lab: 45 Minutes

Task: Rather than rendering a list of Country names for the user to click. Change the application to have a drop down of Countries for the user to select.

* Create a new component called `CountrySelect` which takes in the Countries and a `onCountrySelected` function that will set the `selectedCountry` as props.

* Render this component from CountryContainer replacing the CountryList component. 

* in `CountrySelect` create a drop down and use the countries list passed in to create an option for each country. The value for this will be the index of the country in the array, **not** the full object. 

* In `CountrySelect` create an onChange function that takes in the index number, finds the country from the array and calls the `onCountrySelected` prop.