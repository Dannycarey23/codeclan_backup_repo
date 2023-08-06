import React from 'react';

const Ship = (props) => {

	return (
		<div className="component">
			<p className="name">
				{props.ship.name}
			</p>
		</div>
	)
}

export default Ship;
