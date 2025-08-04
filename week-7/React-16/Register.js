import React, { useState } from 'react';

function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validation
    if (name.length < 5) {
      alert('Full Name must be 5 characters long!');
      return;
    }

    if (!email.includes('@') || !email.includes('.')) {
      alert('Email is not valid!');
      return;
    }

    if (password.length < 8) {
      alert('Password must be 8 characters long!');
      return;
    }

    // If all validations pass
    alert('Registered Successfully!');
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '200px' }}>
      <h1 style={{ color: 'red' }}>Register Here!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name: </label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div><br />
        <div>
          <label>Email: </label>
          <input
            type="text"  // ← remove `type="email"` to prevent default tooltip
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div><br />
        <div>
          <label>Password: </label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Register;
