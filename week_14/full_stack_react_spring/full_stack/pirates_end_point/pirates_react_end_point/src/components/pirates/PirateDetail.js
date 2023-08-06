import React from 'react';
import Pirate from "./Pirate";

import { useNavigate } from 'react-router-dom';


const PirateDetail = ({ pirate, handleDelete }) => {
    const navigate = useNavigate();

    if (pirate) {

        const piratesRaids = pirate.raids.map((raid, index) => {
            return <li key={index}>{raid.location}</li>
        })

        const onDelete = () => {
            handleDelete(pirate.id)
        }

        const onEdit = () => {
            navigate(`/pirates/${pirate.id}/edit`);
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
                <button onClick={onEdit}>Edit</button>
            </div>
        )
    }

    return (
        <p>Loading.....</p>
    )
}

export default PirateDetail;