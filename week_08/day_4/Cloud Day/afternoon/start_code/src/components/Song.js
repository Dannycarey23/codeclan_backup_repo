import React, { useEffect, useState, useRef } from 'react';

function Song({title, artist, position, image, audio}) {
  const [isPlaying, setIsPlaying] = useState(null)
  const audioSrc = useRef(null)

  const altTag = `${title} by ${artist}`;

  const handlePlayPause = () => {
    setIsPlaying(!isPlaying);
  }

  useEffect(() => {
    if (isPlaying === null) {
      return;
    }

    isPlaying ? audioSrc.current.play() : audioSrc.current.pause()
  }, [isPlaying])

  return (
    <div className="song">
      <img
        alt={"Play " + altTag}
        id={position}
        className={`audio-control ${isPlaying ? "playing" : ""}`}
        src='https://image.freepik.com/free-icon/play-button_318-42541.jpg'
        onClick={handlePlayPause}
      />

      <img
        src={image}
        alt={altTag} />

      <div className='details'>
        <h3>{position}. {title}</h3>
        <h4>{artist}</h4>
      </div>

      <audio
        ref={audioSrc}
        id={'audio' + position}
        src={audio} 
      />
    </div>
  );
}

export default Song;
