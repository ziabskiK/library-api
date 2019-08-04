import React from 'react'
import axios from 'axios'
import './Search.css'

class SearchResult extends React.Component {

    state = {
        books: []
    }

    componentDidMount() {
        let searchByName = this.props.search;
        let field = this.props.field;

        const api = 'http://localhost:8080/book/' + field + '?' + field + '=' + searchByName;


        axios.get(api).then(
            res => this.setState({books: res.data})
        )
    }

    componentDidUpdate(prevState) {
        let searchByName = this.props.search;
        let field = this.props.field;


        axios.get('http://localhost:8080/book/' + field + '?' + field + '=' + searchByName).then(
            res => {

                if (field !== prevState.field) {
                    this.setState({books: res.data})
                }

                if (searchByName !== prevState.search) {
                    this.setState({books: res.data})

                }
            }
        )
    }

    handleClick(book) {
        console.log(book)
    }

    render() {
        let books = this.state.books.map((book, index) => {
            return (
                <li key={index}>
                    <a href='#'
                       onClick={this.handleClick.bind(this, book.id)}>{book.authorFirstName} {book.authorLastName} -
                        "{book.title}"</a>
                </li>
            )
        })
        return (
            //check if fetched data is not empty
            this.state.books.length !== 0 ? (<ul>{books}</ul>) :
                <h2 style={{color: 'white'}}>Sorry we could not find book for {this.props.field} :( Please try
                    again.</h2>
        )
    }
}

export default SearchResult