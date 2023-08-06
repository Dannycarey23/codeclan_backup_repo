import React from 'react';

const TitleBar = ({handleSelectChange, genres}) =>{
  return (
    <div>
      <h1>Hit Parade</h1>
      <select onChange={handleSelectChange}>
        {genres.map(genre => {
          return <option key={genre.name} value={genre.url}>{genre.name}</option>
        })}
      </select>
    </div>
  );
};

export default TitleBar;
