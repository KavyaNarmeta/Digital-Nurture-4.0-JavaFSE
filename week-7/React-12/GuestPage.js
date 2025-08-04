import React from 'react';
import FlightDetails from './FlightDetails';

const GuestPage = () => {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Please login to book your tickets.</p>
      <FlightDetails />
    </div>
  );
};

export default GuestPage;
