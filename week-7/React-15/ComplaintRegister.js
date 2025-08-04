// src/ComplaintRegister.js
import React, { useState } from "react";

const ComplaintRegister = () => {
  const [name, setName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const transactionId = Math.floor(Math.random() * 1000);
    alert(`Thanks ${name}\nYour Complaint was Submitted.\nTransaction ID is: ${transactionId}`);
    setName("");
    setComplaint("");
  };

  return (
    <div style={{ textAlign: "center", marginTop: "300px" }}>
      <h1 style={{ color: "red" }}>Register your complaints here!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label style={{ marginRight: "10px" }}>Name:</label>
          <input
            type="text"
            value={name}
            required
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <br />
        <div>
          <label style={{ marginRight: "10px" }}>Complaint:</label>
          <textarea
            value={complaint}
            required
            onChange={(e) => setComplaint(e.target.value)}
          />
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default ComplaintRegister;
