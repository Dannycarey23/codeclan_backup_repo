import React from 'react';
import styled from 'styled-components';

const Basketlist = styled.div`
    width:80%;
    margin: auto;
    padding: 10px;
    background-color: lightgrey;
    color: black;
    box-shadow: 4px 4px 4px 4px grey;
`

const Button = styled.button `
    background-color: white;
    color: black;
    margin: 5px;
    border: 2px solid grey; 
    border-radius: 8px;
`

const Basket = ( { user, onRemoveItem } ) => {


    const removeItem = ( itemToRemove ) => {
        const updatedUser = { ...user };
        updatedUser.basket = [ ...user.basket ];
        const index = updatedUser.basket.indexOf( itemToRemove );
        updatedUser.basket.splice( index, 1 );
        onRemoveItem( updatedUser );
    };

    const basketComponents = user.basket.map( item => (
        <li>
            <hr />
            <span>
                { item.name } £{ item.price }
                <img src={ require( "../images/" + item.image ) } alt="item" />
            </span>
            <Button onClick={ () => removeItem( item ) }>Remove</Button>
        </li >
    ) );

    return (
        <Basketlist>
            <h2>Your items: </h2>
            { user.basket.length > 0
                ? <ul >
                    { basketComponents }
                </ul>
                : <p>Basket Is Empty</p> }
        </Basketlist>
    );
};

export default Basket;
