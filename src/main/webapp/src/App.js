import React, { Component } from 'react';
import './App.css';
import Table from './Table';
import NameForm from "./NameForm";

class App extends Component {
  render() {
    return (
      <div className="App">
        <Table/>
        <NameForm/>
      </div>
    );
  }
}

export default App;
