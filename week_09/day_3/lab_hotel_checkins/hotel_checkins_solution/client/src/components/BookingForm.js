import { useState } from 'react';

const BookingForm = ({addBooking}) => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [checkedIn, setCheckedIn] = useState(false);

  const handleNameChange = (ev) => setName(ev.target.value);
  const handleEmailChange = (ev) => setEmail(ev.target.value);
  const handleCheckInChange = (ev) => setCheckedIn(ev.target.checked ? ev.target.checked : false);

  const handleSubmit = ev => {
    ev.preventDefault();
    addBooking({
      name: name,
      email: email,
      checked_in: checkedIn
    });
    setName("");
    setEmail("");
    setCheckedIn(false);
  }

  return (
    <form onSubmit={handleSubmit}>
      <h1>Add a booking</h1>
      <div className="group">
        <label htmlFor="name">Guest Name:</label>
        <input 
          type="text" 
          id="name" 
          name="name" 
          value={name} 
          required 
          onChange={handleNameChange}
        />
      </div>
      <div className="group">
        <label htmlFor="email">Guest Email:</label>
        <input 
          type="email" 
          id="email" 
          name="email" 
          value={email} 
          required 
          onChange={handleEmailChange}
        />
      </div>

      <div className="group">
        <label htmlFor="checked_in">Checked In:</label>
        <input 
          type="checkbox" 
          id="checked_in" 
          name="checked_in" 
          value={checkedIn} 
          onChange={handleCheckInChange}
        />
      </div>

      <input type="submit" name="submit" value="Save" />
    </form>
  )
};

export default BookingForm;