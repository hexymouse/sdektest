import React, { Component } from 'react';
import './App.css';
import Table from './Table';
import NameForm from "./NameForm";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {lastAdded: ''};
    }

    addLast = (data) => {
        this.setState((prevState) => {
            return {lastAdded: data};
        });
    };

    render() {
        return (
            <div className="App">
                <Table last={this.state.lastAdded}/>
                <NameForm addLast={this.addLast}/>
            </div>
        );
    }
}

export default App;
