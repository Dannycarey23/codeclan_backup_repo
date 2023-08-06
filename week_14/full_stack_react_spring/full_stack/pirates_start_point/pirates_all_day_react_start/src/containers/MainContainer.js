import React from 'react';
import { Route, Routes } from 'react-router-dom';
import NavBar from '../components/NavBar';
import PirateContainer from './PirateContainer.js';


const MainContainer = () => {

  return (
    <div>
      <NavBar />
      <Routes>
        <Route path="/pirates/*" element={<PirateContainer />} />
      </Routes>
    </div>
  )
}

export default MainContainer;
