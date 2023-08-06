import React from 'react';
import EpisodeListItem from './EpisodeListItem';
import './EpisodeList.css';

const EpisodeList = ({episodes}) => {
  
    const episodeItems = episodes.map((episode, index) => {
      return <EpisodeListItem key={index} episode={episode} />
    })

    return (
        <div className="episode-list">
    <h3>Episode List</h3>
    <ul>
      {episodeItems}
    </ul>
  </div>
    )
}

export default EpisodeList;