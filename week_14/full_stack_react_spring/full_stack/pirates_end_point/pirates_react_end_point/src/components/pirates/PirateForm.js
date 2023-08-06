import React, { useState } from 'react';

const PirateForm = ({ ships, onCreate }) => {

    const [statePirate, setStatePirate] = useState(
        {
            firstName: "",
            lastName: "",
            age: 0,
            ship: null
        }
    )

    if (!ships.length === 0) {
        return <p>Loading...</p>
    }

    const handleChange = function (event) {
        let propertyName = event.target.name;
        let copiedPirate = { ...statePirate }
        copiedPirate[propertyName] = event.target.value;
        setStatePirate(copiedPirate)
    }

    const handleShip = function (event) {
        const index = parseInt(event.target.value)
        const selectedShip = ships[index]
        let copiedPirate = { ...statePirate };
        copiedPirate['ship'] = selectedShip
        setStatePirate(copiedPirate)
    }

    const handleSubmit = function (event) {
        event.preventDefault();
        onCreate(statePirate);
    }

    const shipOptions = ships.map((ship, index) => {
        return <option key={index} value={index}>{ship.name}</option>
    })

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="First Name" name="firstName" onChange={handleChange} value={statePirate.firstName} />
                <input type="text" placeholder="Last Name" name="lastName" onChange={handleChange} value={statePirate.lastName} />
                <input type="number" placeholder="Age" name="age" onChange={handleChange} value={statePirate.age} />
                <select name="ship" onChange={handleShip} defaultValue="select-ship">
                    <option disabled value='select-ship'>Select a ship</option>
                    {shipOptions}
                </select>

                <button type="submit">Save</button>
            </form>
        </div>
    )

}

export default PirateForm;

