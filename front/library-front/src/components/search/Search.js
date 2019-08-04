import React from 'react';
import '../search/Search.css'
import Radio from '@material-ui/core/Radio';

import SearchResult from './SearchResult';
import Post from '../main-content/Posts'
import {FormControlLabel, RadioGroup} from '@material-ui/core';
import {Input} from 'reactstrap'


class Search extends React.Component {

    state = {
        search: null,
        enter: "Please enter author last name",
        field: 'author'
    }

    handleKey = (e) => {
        if (e.key === 'Enter') {
            this.setState({search: e.target.value})
        }
    }

    handleRadioChange = (e, checked) => {
        let search = e.target.value

        if (search === 'author') {
            this.setState({
                enter: "Please enter " + search + " last name",
                field: 'author'
            })
        } else {


            this.setState({
                enter: "Please enter " + e.target.value,
                field: search
            })
        }


    }

    render() {
        let search = this.state.search
        let field = this.state.field


        // check if search input is not empty 
        let dataIsFetched = search ? (
            <div>
                <div className='search'>
                    <SearchResult search={search} field={field}/>
                </div>
            </div>

        ) : <Post/> // here will be rendered

        return (
            <div className='flex'>

                <Input id="input" className='mt-4 mr-2 ml-4' placeholder={this.state.enter}
                       onKeyDown={this.handleKey.bind(this)}/>
                <RadioGroup value={this.state.field}>
                    <FormControlLabel value='author' control={<Radio onChange={this.handleRadioChange.bind(this)}/>}
                                      label="Author" defaultChecked={true}/>
                    <FormControlLabel value='title' control={<Radio onChange={this.handleRadioChange.bind(this)}/>}
                                      label="Title"/>
                </RadioGroup>

                {dataIsFetched}
            </div>
        )
    }
}

export default Search