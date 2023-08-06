import React, { useState } from 'react';
import MortgageForm from '../components/MortgageForm';
import MortgageDisplay from '../components/MortgageDisplay';

function MortgageContainer() {
  const [maxAmount, setMaxAmount] = useState();

  const handleSubmit = (data) => {
    const yearlyCommittments = data.other * 12;
    const yearlySalaries = (data.salary1 + data.salary2) - yearlyCommittments;
    const max = data.deposit + (yearlySalaries * 3);
    setMaxAmount(max);
  }

  return (
    <>
      <h1>Mortgage Calculator</h1>
      <MortgageForm onSubmit={handleSubmit} />
      <MortgageDisplay maxAmount={maxAmount} />
    </>
  );
}

export default MortgageContainer;
