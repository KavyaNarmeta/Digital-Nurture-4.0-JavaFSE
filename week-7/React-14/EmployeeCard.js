import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const buttonClass = theme === 'dark' ? 'btn-dark' : 'btn-light';

  return (
    <div className="employee-card">
      <h3>{employee.name}</h3>
      <p>{employee.role}</p>
      <button className={buttonClass}>View Details</button>
    </div>
  );
}

export default EmployeeCard;
