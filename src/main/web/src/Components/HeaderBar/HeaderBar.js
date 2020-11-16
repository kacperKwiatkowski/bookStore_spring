import React from "react";
import './HeaderBar.css';
import logo from "./logo.png"
import { HeaderBarItems } from "./HeaderBarItems";
import { Button } from "../Button.js"
import { Link } from 'react-router-dom'
import { useHistory } from 'react-router-dom';

export class HeaderBar extends React.Component {
    state = { clicked: false }

    handleClick = () => {
        this.setState({ clicked: !this.state.clicked})
    }

    render() {
        return (

            <nav className="headerBar">
                <div className="headerBar-logo">
                    <Link className="headerBar-logo" to="/home">ECLIPSE</Link>
                </div>
                <div>
                    <input className="headerNav-searchBar" type="text"/>
                </div>
                <div className="menu-icon" onClick={this.handleClick}>
                    <i className={this.state.clicked ? `fas fa-times` : `fas fa-bars`}/>
                </div>
                <ul className={this.state.clicked ? `headerBar-menu active` : `headerBar-menu`}>
                    {HeaderBarItems.map((item, index) => {
                        return(
                            <li key={index} >
                                <Link className={item.cName} to={item.url}>{item.title}</Link>
                            </li>
                        )
                    })}
                </ul>
            </nav>
        )
    }
}
export default HeaderBar