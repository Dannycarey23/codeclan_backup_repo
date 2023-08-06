import React from 'react';
import './CharacterSelect.css';

const CharacterSelect = ({characters, handleSelectChange}) => {

    const handleChange = (event) => {
      const index = event.target.value;
      handleSelectChange(characters[index]);
    }

    const characterOptions = characters.map((character, index) => {
      return <option key={index} value={index}>{character.name}</option>
    });

    return (
        <select onChange={handleChange}>
            {characterOptions}
        </select>
    )
  
}

export default CharacterSelect;