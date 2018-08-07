import React, { Component } from 'react';
import axios from 'axios';

class Table extends Component{
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
        let data = this.state.data;

        if (this.props.filtered instanceof Object) {
            data = this.props.filtered;
            this.props.last = null;
        }

        if (this.props.last instanceof Object) {
            data.push(this.props.last);
        }

        let tableTemplate;
        
        function makeIdColumn(row) {
            return <td>{row.id}</td>
        }

        function makeNameColumn(row) {
            return <td>{row.name}</td>
        }

        tableTemplate = data.map((row, i) => {
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

export default Table;

