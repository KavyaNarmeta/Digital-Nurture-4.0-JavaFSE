// src/Components/CountPeople.js
import React, { Component } from 'react';
import '../CountPeople.css';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1
    }));
  };

  render() {
    return (
      <div className="container">
        <div className="block">
          <button onClick={this.updateEntry}>Login</button>
          <span>{this.state.entryCount} People Entered!!!</span>
        </div>
        <div className="block">
          <button onClick={this.updateExit}>Exit</button>
          <span>{this.state.exitCount} People Left!!!</span>
        </div>
      </div>
    );
  }
}

export default CountPeople;
    