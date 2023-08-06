import React, { useState } from 'react';

function RepaymentCalculator({ amount }) {
  // const [interestRate, setInterestRate] = useState(3.0);
  // const [term, setTerm] = useState(20);
  const [formData, setFormData] = useState({
    interestRate: 3.0,
    term: 20
  });

  const handleChange = (event) => {
    const newState = {...formData};
    newState[event.target.name] = event.target.value;
    setFormData(newState);
  }

  const calculateMonthly = () => {
    const principal = amount;
    const monthly_interest = (formData.interestRate / 100) / 12;
    const number_of_payments = formData.term * 12;

    const numerator = (monthly_interest * Math.pow(1 + monthly_interest, number_of_payments));
    const denominator = Math.pow(1 + monthly_interest, number_of_payments) - 1;

    const monthly_payments = principal * (numerator / denominator);

    return parseInt(monthly_payments);
  }

  return (
    <form>
      <div className="form_wrap">
        <label htmlFor="interestRate">Interest Rate %:</label>
        <input
          onChange={handleChange}
          name="interestRate"
          id="interestRate"
          type="number"
          min="0"
          step="0.1"
          value={formData.interestRate}
        />
      </div>

      <div className="form_wrap">
        <label htmlFor="term">Term in years:</label>
        <input
          onChange={handleChange}
          name="term"
          id="term"
          type="range"
          min="1"
          max="30"
          value={formData.term}
        />
      </div>

      <p>
        At {formData.interestRate}%, over {formData.term} year{formData.term > 1 ? "s":""},your monthly payments will be around £{calculateMonthly()}.
      </p>
    </form>
  );
}

export default RepaymentCalculator;
