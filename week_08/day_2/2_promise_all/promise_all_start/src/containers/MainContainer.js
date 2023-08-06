import React, { useState, useEffect } from 'react';
import CharacterSelect from '../components/CharacterSelect';
import CharacterDetail from '../components/CharacterDetail';
import './MainContainer.css';

const MainContainer = () => {

    const [ characters, setCharacters ] = useState( [] )
    const [ selectedCharacter, setSelectedCharacter ] = useState( null )

    useEffect( () => {
        fetch( 'https://rickandmortyapi.com/api/character/' )
            .then( res => res.json() )
            .then( data => setCharacters( data.results ) )
    }, [] )

    const handleSelectChange = ( character ) => {
        setSelectedCharacter( character );
    }

    return (
        <div>
            <h1>Characters</h1>
            <CharacterSelect characters={ characters } handleSelectChange={ handleSelectChange } />
            { selectedCharacter ? <CharacterDetail character={ selectedCharacter } /> : null }
        </div>
    )
}

export default MainContainer
