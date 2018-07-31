import React, { Component } from 'react';
import axios from 'axios';

export default class NameForm extends Component{
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        axios({
            method: 'post',
            url: '/entity',
            data: {name: this.state.value},
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (response) {
                console.log(response);
            });
        // this.setState({value: ''});
        window.location.reload();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input type="text" value={this.state.value} onChange={this.handleChange} className="inputName" />
                <input type="submit" value="Submit" className="submitName"/>
            </form>
        );
    }
}


