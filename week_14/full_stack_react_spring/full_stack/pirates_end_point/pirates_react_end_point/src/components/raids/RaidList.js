import React from 'react';
import Raid from './Raid.js';


const RaidList = (props) => {
	const raids = props.raids.map((raid) => {
		return (<li key={raid.id} className="component-item">
			<Raid raid={raid} />
		</li>
		)
	})

	return (
		<ul className="component-list">
			{raids}
		</ul>

	)
}
export default RaidList;
