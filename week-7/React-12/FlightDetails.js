import React from 'react';

const FlightDetails = ({ showBookingButton = false }) => {
  const flights = [
    { id: 1, from: 'Delhi', to: 'Mumbai', time: '10:00 AM' },
    { id: 2, from: 'Hyderabad', to: 'Bangalore', time: '3:00 PM' },
  ];

  return (
    <div>
      <h3>Available Flights</h3>
      <ul>
        {flights.map((flight) => (
          <li key={flight.id}>
            {flight.from} ➡️ {flight.to} at {flight.time}
            {showBookingButton && <button>Book Now</button>}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FlightDetails;
