import React from "react";
import "./App.css";

const App = () => {
  const officeSpaces = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: "https://png.pngtree.com/background/20230602/original/pngtree-modern-business-office-workplace-background-picture-image_2859524.jpg",
    },
    {
      name: "WeWork",
      rent: 70000,
      address: "Bangalore",
      image: "https://designtechnics.in/wp-content/uploads/2017/10/3.jpg",
    },
    {
      name: "Regus",
      rent: 55000,
      address: "Hyderabad",
      image: "https://designtechnics.in/wp-content/uploads/2017/10/4.jpg",
    },
  ];

  return (
    <div className="container">
      <h1>Office Space, at Affordable Range</h1>
      {officeSpaces.map((office, index) => (
        <div key={index} className="card">
          <img src={office.image} alt={office.name} />
          <h2>Name: {office.name}</h2>
          <p className={office.rent < 60000 ? "rent-red" : "rent-green"}>
            Rent: Rs. {office.rent}
          </p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
};

export default App;
