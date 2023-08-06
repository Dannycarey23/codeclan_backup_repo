import React, { useState } from 'react';

function MortgageForm({ onSubmit }) {
  const [formData, setFormData] = useState({
    salary1: '',
    salary2: '',
    deposit: '',
    other: ''
  });

  const handleChange = (event) => {
    const newState = {...formData};
    newState[event.target.name] = parseInt(event.target.value);
    setFormData(newState);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit(formData);
  }

  return (
    <form>
      <div className="form_wrap">
        <label htmlFor="salary1">Your salary:</label>
        <input
          onChange={handleChange}
          min="0"
          step="1000"
          name="salary1"
          id="salary1"
          type="number"
          value={formData.salary1} />
      </div>

      <div className="form_wrap">
        <label htmlFor="salary2">Your partner's salary:</label>
        <input
          onChange={handleChange}
          min="0"
          step="1000"
          name="salary2"
          id="salary2"
          type="number"
          value={formData.salary2}/>
      </div>

      <div className="form_wrap">
        <label htmlFor="deposit">Your deposit:</label>
        <input
          onChange={handleChange}
          min="0"
          step="1000"
          type="number"
          id="deposit"
          name="deposit"
          value={formData.deposit} />
      </div>

      <div className="form_wrap">
        <label htmlFor="other">Other monthly commitments:</label>
        <input
          onChange={handleChange}
          min="0"
          step="100"
          type="number"
          id="other"
          name="other"
          value={formData.other} />
      </div>

      <input onClick={handleSubmit} type="submit" value="submit" />
    </form>
  );
}

export default MortgageForm;
