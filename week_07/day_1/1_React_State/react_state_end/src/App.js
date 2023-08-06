import './App.css';
import React, {useState} from 'react'

function App() {
 
  const [greeting, setGreeting] = useState("Hello World")
  const [total, setTotal] = useState(0);

  const handleClick = (name) => {
    setGreeting("Hello " + name)
  }

  const deposit = () => {                           
    setTotal(total + 10);                           
  }

  const withdraw = () => {
    if(total >= 10){
      setTotal(total - 10)
    }
  }

  return (
    <div className="App">

        <h1>{greeting}</h1>
        <button onClick={() => handleClick("John")}>Change Greeting</button>

        <p>Total: £{total}</p>
        <button onClick={deposit}>Deposit</button>
        <button onClick={withdraw}>Withdraw</button>
        
    </div>
  );
}

export default App;
