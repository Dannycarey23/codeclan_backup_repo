import React from 'react';
import MovieItem from './MovieItem';
import './MovieList.css';

const MovieList = ({movies}) => {
  const movieItems = movies.map((movie) => {
    return (
      <MovieItem movie={movie} key={movie.id}/>
    );
  });

  return (
    <div className='movie-list'>
      <ul>
        {movieItems}
      </ul>
    </div>
  );

}

export default MovieList;
