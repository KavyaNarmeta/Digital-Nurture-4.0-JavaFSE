import React from 'react';
import EmployeeCard from './EmployeeCard';

const employeeData = [
  { id: 1, name: 'John Doe', role: 'Developer' },
  { id: 2, name: 'Jane Smith', role: 'Designer' },
];

function EmployeesList() {
  return (
    <div>
      {employeeData.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
