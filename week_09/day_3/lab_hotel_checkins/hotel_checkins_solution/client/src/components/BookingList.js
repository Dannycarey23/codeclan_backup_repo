import Booking from "./Booking";

const BookingList = ({bookings, updateBooking, deleteBooking}) => {
  const bookingNodes = bookings.map(booking => {
    return <Booking 
      key={booking._id} 
      booking={booking}
      updateBooking={updateBooking}
      deleteBooking={deleteBooking}
    />
  });

  return (
    <section id="bookings">
      <h2>Booking List</h2>
      <div id="bookings-wrapper">
        {bookingNodes}
      </div>
    </section>
  )
};

export default BookingList;