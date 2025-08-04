import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '',
      firstname: '',
      image: '',
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      const user = data.results[0];

      this.setState({
        title: user.name.title,
        firstname: user.name.first,
        image: user.picture.medium,
      });
    } catch (error) {
      console.error('Error fetching user:', error);
    }
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '100px' }}>
        <h1>
          {this.state.title} {this.state.firstname}
        </h1>
        <img src={this.state.image} alt="User" />
      </div>
    );
  }
}

export default Getuser;
