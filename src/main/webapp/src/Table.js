import React, { Component } from 'react';
import axios from 'axios';

export default class Table extends Component{
    constructor(props) {
        super(props);

        this.state = {
            data: []
        };
    }

    componentDidMount() {
        axios.get('/entity')
            .then(res => {
               const data = res.data;
               this.setState({data});
            });
    }

    render() {
        let tableTemplate;
        
        function makeIdColumn(row) {
            return <td>{row.id}</td>
        }

        function makeNameColumn(row) {
            return <td>{row.name}</td>
        }

        tableTemplate = this.state.data.map((row, i) => {
            return <tr key={i}>{makeIdColumn(row)}{makeNameColumn(row)}</tr>
        });

        return (
            <table className="namesTable" id="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                    {tableTemplate}
                </tbody>
            </table>
        );
    }
}

