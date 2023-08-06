import React, { useState, useEffect } from 'react';
import snd from "./sound";

function Metronome() {
  const [bpm, setBpm] = useState(40);
  const [intervalId, setIntervalId] = useState(null);
  
  useEffect(() => {
    if (intervalId) {
      stop();
      play();
    }
  }, [bpm]);

  const handleChange = (event) => {
    setBpm(event.target.value);
  }

  const play = () => {
    let timeInterval = (1000 * 60) / bpm;

    let interval = setInterval(() => {
      snd.play();
    }, timeInterval);

    setIntervalId(interval);
  }

  const stop = () => {
    clearInterval(intervalId);
    setIntervalId(null);
  }

  return (
    <>
      <h1>Metronome</h1>
      <p><span className="bpm">{bpm}</span> bpm</p>
      <input
        type="range"
        min="40"
        max="120"
        step="1"
        value={bpm}
        onChange={handleChange}
      />
      <button onClick={play}>Play</button>
      <button onClick={stop}>Stop</button>
    </>
  );
}

export default Metronome;
