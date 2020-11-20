import React from 'react'
import './App.css';
import {HeaderBar} from "./Components/HeaderBar/HeaderBar";
import {SearchBar} from "./Components/SearchBar/SearchBar";
import { HeaderNav } from "./Components/HeaderNav/HeaderNav";
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import {Login} from './Pages/Login/Login'
import {Register} from './Pages/Register/Register'
import {Home} from './Pages/Home'

function App() {
    return (
        <div className="App">
            <Router>{/*
                <header>*/}
                    <HeaderBar/>
                    <SearchBar/>
                    <HeaderNav />{/*
                </header>*/}
                <Switch>
                    <Route path='/home' component={Home}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/register' component={Register}/>
                </Switch>
            </Router>
        </div>
    )
}

export default App;
