import React from 'react';

const Raid = (props) => {

  return (
    <div className="component">
      <p className="name">
        {props.raid.location}
      </p>
      <p>Loot: {props.raid.loot}</p>
    </div>
  )
}

export default Raid;
