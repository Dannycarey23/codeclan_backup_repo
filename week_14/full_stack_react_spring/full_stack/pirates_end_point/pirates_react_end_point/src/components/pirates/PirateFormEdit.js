import React, { useState } from 'react';

const PirateFormEdit = ({ pirate, ships, onEdit }) => {

    const [statePirate, setStatePirate] = useState(
        {
            id: pirate.id,
            firstName: pirate.firstName,
            lastName: pirate.lastName,
            age: pirate.age,
            ship: pirate.ship
        }
    )

    if (ships.length === 0 || !pirate) {
        return <p>Loading...</p>
    }

    const handleChange = function (event) {
        let propertyName = event.target.name;
        let copiedPirate = { ...statePirate }
        copiedPirate[propertyName] = event.target.value;
        setStatePirate(copiedPirate)
    }

    const handleShip = function (event) {
        const selectedShip = ships.find(ship => ship.id == event.target.value);
        let copiedPirate = { ...statePirate };
        copiedPirate['ship'] = selectedShip
        setStatePirate(copiedPirate)
    }

    const handleSubmit = function (event) {
        event.preventDefault();
        onEdit(statePirate);
    }

    const shipOptions = ships.map((ship, index) => {
        return <option key={index} value={ship.id}>{ship.name}</option>
    })

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="First Name" name="firstName" onChange={handleChange} value={statePirate.firstName} />
                <input type="text" placeholder="Last Name" name="lastName" onChange={handleChange} value={statePirate.lastName} />
                <input type="number" placeholder="Age" name="age" onChange={handleChange} value={statePirate.age} />
                <select name="ship" onChange={handleShip} defaultValue={pirate.ship.id}>
                    <option disabled value='select-ship'>Select a ship</option>
                    {shipOptions}
                </select>

                <button type="submit">Save</button>
            </form>
        </div>
    )

}

export default PirateFormEdit;

