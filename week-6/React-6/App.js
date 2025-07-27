// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Components/Home';
import TrainersList from './Components/TrainerList';
import TrainerDetails from './Components/TrainerDetails';
import trainers from './Components/TrainerMock';

function App() {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link> |{' '}
          <Link to="/trainers">Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList data={trainers} />} />
          <Route path="/trainer/:id" element={<TrainerDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
