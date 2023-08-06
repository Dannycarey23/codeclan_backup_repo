import React from 'react';
import RepaymentCalculator from './RepaymentCalculator';

const MortgageDisplay = ({ maxAmount }) => {
  if (!maxAmount) {
    return null;
  }

  return (
    <>
      <p>You can afford a maximum of £{maxAmount}.</p>
      <RepaymentCalculator amount={maxAmount} />
    </>
  );
};

export default MortgageDisplay;
