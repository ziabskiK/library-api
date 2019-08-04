import React, {Component} from 'react';

import './App.css';
import Search from "./components/search/Search"
import Menu from './components/menu/Menu';
import Home from './components/home/Home'

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Login from "./components/login/Login";
import Register from "./components/register/Register";

class App extends Component {


    render() {
        return (


            <Router>
                <Menu/>


                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route path='/search' component={Search}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/register' component={Register}/>

                </Switch>


            </Router>


        );
    }
}

export default App;
