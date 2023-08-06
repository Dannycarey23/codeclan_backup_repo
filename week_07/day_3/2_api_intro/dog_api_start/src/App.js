import {useState} from "react";
import './App.css';

function App() {

    const [dogImgUrl, setDogImgUrl] = useState("");

  const fetchDog = function(){
    console.log("Hello from fetchDog!")
  }

  return (
    <div id="app">
    <h1>RANDOGMISER</h1>
    <img id="dog-img" src={dogImgUrl} />
    <button onClick={fetchDog}>Gimme those dogs!</button>
    </div>
  );
}

export default App;
