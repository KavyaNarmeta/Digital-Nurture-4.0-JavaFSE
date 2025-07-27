import React, { useState } from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const [name, setName] = useState('');
  const [school, setSchool] = useState('');
  const [total, setTotal] = useState('');
  const [goal, setGoal] = useState('');
  const [average, setAverage] = useState(null);

  const handleCalculate = () => {
    if (!total || isNaN(total)) {
      alert("Please enter a valid total score");
      return;
    }
    const avg = parseFloat(total) / goal;  
    setAverage(avg.toFixed(2));
  };

  return (
    <div className="score-card">
      <h2>Score Calculator</h2>
      <input type="text" placeholder="Enter Name" onChange={(e) => setName(e.target.value)} />
      <input type="text" placeholder="Enter School" onChange={(e) => setSchool(e.target.value)} />
      <input type="text" placeholder="Enter Total Marks" onChange={(e) => setTotal(e.target.value)} />
      <input type="text" placeholder="Enter Goal" onChange={(e) => setGoal(e.target.value)} />
      <button onClick={handleCalculate}>Calculate Average</button>
      
      {average && (
        <div className="result">
          <p><strong>Name:</strong> {name}</p>
          <p><strong>School:</strong> {school}</p>
          <p><strong>Total Marks:</strong> {total}</p>
          <p><strong>Goal:</strong> {goal}</p>
          <p><strong>Average Score:</strong> {average}</p>
        </div>
      )}
    </div>
  );
}

export default CalculateScore;
