import React from 'react';
import Pirate from "./Pirate";

const PirateDetail = ({ pirate, handleDelete }) => {

    if (pirate) {

        const piratesRaids = pirate.raids.map((raid, index) => {
            return <li key={index}>{raid.location}</li>
        })

        const onDelete = () => {
            handleDelete(pirate.id)
        }

        return (
            <div className="component">
                <Pirate pirate={pirate} />
                <p>Raids:</p>
                <ul>
                    {piratesRaids}
                </ul>
                <p>Ship:</p>
                <p>{pirate.ship.name}</p>
                <button onClick={onDelete}>Delete {pirate.firstName}</button>
            </div>
        )
    }

    return (
        <p>Loading.....</p>
    )
}

export default PirateDetail;