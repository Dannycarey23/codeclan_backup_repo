import React from 'react';
import './ListItem.css';

const ListItem = ({country}) => {
  return <li>{country.name.common}</li>
}

export default ListItem;