import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from '../components/Header';
import ItemsList from '../components/ItemsList';
import storedItems from '../data/ShopItems';
import Basket from '../components/Basket'

const MainContainer = () => {
  const [user, setUser] = useState({
    name: "John Smith",
    email: "js@email.com",
    funds: 150,
    basket: []
  });
  const [items, setItems] = useState(storedItems);

  return (
      <Router>
        <Header user={user} />
        <Routes>
          <Route path="/" element={ <ItemsList items={items} user={user} onBasketAdd={setUser} />} />
          <Route path="/basket" element={<Basket user={user} onRemoveItem={setUser} />} />
        </Routes>
      </Router>
    );
    
};

export default MainContainer;