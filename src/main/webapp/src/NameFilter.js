import React, { Component } from 'react';
import axios from 'axios';

export default class NameFilter extends Component{
    constructor(props) {
        super(props);
        this.state = {
            value: '',
            response: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleResponse = this.handleResponse.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleResponse(responseData) {
        this.setState({response: responseData});
        this.props.filterName(responseData);
    }

    handleSubmit(event) {
        var self = this;
        event.preventDefault();
        axios.get('/entity/filter', {
                params: {
                    name: this.state.value
                }
            })
            .then(function (response) {
                self.handleResponse(response.data);
                console.log(response.data);
            })
            .catch(function (response) {
                console.log(response.data );
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input type="text" value={this.state.value} onChange={this.handleChange} className="inputName" />
                <input type="submit" value="Filter" className="submitName"/>
            </form>
        );
    }
}


