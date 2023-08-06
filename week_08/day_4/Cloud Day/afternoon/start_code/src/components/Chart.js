import React from 'react';
import Song from './Song';

const Chart = ({ songs }) => {
  if (songs === null || songs.length === 0) {
    return <p>Loading...</p>;
  }
  
  return (
    <div id="chart">
      {songs.map((song, index) => {
        return (
          <Song
            key={song.id.attributes["im:id"]}
            position={index + 1}
            title={song['im:name'].label}
            artist={song['im:artist'].label}
            image={song['im:image'][1].label}
            audio={song.link[1].attributes.href}
          />
        );
      })}
    </div>
  );
};

export default Chart;
