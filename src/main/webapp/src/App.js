import React, { Component } from 'react';
import './App.css';
import Table from './Table';
import NameForm from "./NameForm";
import NameFilter from "./NameFilter"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {lastAdded: '', filter: ''};
    }

    addLast = (data) => {
        this.setState((prevState) => {
            return {lastAdded: data};
        });
    };

    filterName = (data) => {
        this.setState((prevState) => {
            return {filter: data};
        });
    };

    render() {
        return (
            <div className="App">
                <NameFilter filterName={this.filterName}/>
                <Table last={this.state.lastAdded} filtered={this.state.filter}/>
                <NameForm addLast={this.addLast}/>
            </div>
        );
    }
}

export default App;
