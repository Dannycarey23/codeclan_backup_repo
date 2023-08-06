import React from 'react';
import ListItem from './ListItem';

const CountryList = ({countries, onCountryClicked}) => {

    const countryItems = countries.map((country, index) => {
      return <ListItem country={country} key={index} onCountryClicked={onCountryClicked}/>
    })

  return (
    <div>
    <ul>
      {countryItems}
    </ul>
  </div>
  )
}

export default CountryList;