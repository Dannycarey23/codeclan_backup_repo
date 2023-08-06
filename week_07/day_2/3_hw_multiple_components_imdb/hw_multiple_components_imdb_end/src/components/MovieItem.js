import React from 'react';
import './MovieItem.css';

const MovieItem = ({movie}) => {

  return (
    <li className='movie-item'>
      <a href={movie.url}>{movie.name}</a>
    </li>
  );
}

export default MovieItem;
