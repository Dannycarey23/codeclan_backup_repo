import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import NavBar from "./components/NavBar";
import About from "./components/About";
import Home from "./components/Home";
import Pricing from "./components/Pricing";
import ErrorPage from "./components/ErrorPage";
import Choice from "./components/Choice";

const App = () => {
  let initialPricing = [
    { level: "Hobby", cost: 0 },
    { level: "Startup", cost: 10 },
    { level: "Enterprise", cost: 100 }
  ];
  
  const [pricing, setPricing] = useState(initialPricing);


  return (
    <Router>
        <NavBar />

      <Routes>
        
        <Route exact path="/" element={< Home />} />
        <Route path="/about" element={< About />} />
        <Route
          path="/pricing" exact
          element={ <Pricing prices={pricing} />}
        />
        <Route path="/choices/:choice" element={< Choice />} />
        <Route path="*" element={< ErrorPage />}/>
      </ Routes>
    </Router>
  );
}



export default App;