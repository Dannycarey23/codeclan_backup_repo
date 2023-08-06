import React, { useEffect, useState } from 'react';

function FizzBuzz() {

  const [inputNumber, setInputNumber] = useState(1);
  const [answer, setAnswer] = useState("");
  const [unrelatedState, setUnrelatedState] = useState(0);

  useEffect(() => {
    console.log("Triggering  FizzBuzz side-effect ");
    if (inputNumber % 3 === 0 && inputNumber % 5 === 0) {
      setAnswer("fizzbuz")
    } else if (inputNumber % 3 === 0) {
      setAnswer("fizz")
    } else if (inputNumber % 5 === 0) {
      setAnswer("buzz")
    } else {
      setAnswer(inputNumber);
    }
  }, [inputNumber])



  const unrelatedStateChanged = () => {
    let randomNum = Math.floor(Math.random() * 100);
    setUnrelatedState(randomNum)
  }

  const handleInc = () => {
    let newNum = inputNumber + 1;
    setInputNumber(newNum);
  }

  const handleDec = () => {
    let newNum = inputNumber - 1;
    setInputNumber(newNum);
  }

  return (
    <>

      <button value={unrelatedState} onClick={handleInc}> + </button>

      <button value={unrelatedState} onClick={handleDec}> - </button>

      <button value={unrelatedState} onClick={unrelatedStateChanged}>change unrelated state</button>

      <hr></hr>
      <h2>Num is: <span>{inputNumber}</span></h2>
      <h2>Answer is: <span>{answer}</span></h2>

      <h3>unrelated state: <span>{unrelatedState}</span></h3>
    </>
  );
}

export default FizzBuzz;
