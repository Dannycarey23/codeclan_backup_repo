import React from 'react';
import './ListItem.css';

const ListItem = ({country, onCountryClicked}) => {

  const handleClick = function() {
    console.log(`Clicked on ${country.name.common}`);
    // onCountryClicked(country);
    onCountryClicked(country);
  }

  return (
    <li onClick={handleClick} className="clickable-li">{country.name.common}</li>
  )
}

export default ListItem;