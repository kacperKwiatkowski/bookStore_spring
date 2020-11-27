import React from 'react'
import './App.css';
import {HeaderBar} from "./Components/HeaderBar/HeaderBar";
import {SearchBar} from "./Components/SearchBar/SearchBar";
import { HeaderNav } from "./Components/HeaderNav/HeaderNav";
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import {Home} from './Pages/Home'
import {Contact} from './Pages/Contact/Contact'
import {Basket} from './Pages/Basket/Basket'
import {Login} from './Pages/Login/Login'
import {Register} from './Pages/Register/Register'

function App() {
    return (
        <div className="App">
            <Router>
                    <HeaderBar/>
                    <SearchBar/>
                    <HeaderNav />
                <Switch>
                    <Route path='/home' component={Home}/>
                    <Route path='/contact' component={Contact}/>
                    <Route path='/basket' component={Basket}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/register' component={Register}/>
                </Switch>
            </Router>
        </div>
    )
}

export default App;
