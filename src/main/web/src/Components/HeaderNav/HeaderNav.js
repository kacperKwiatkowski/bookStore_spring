import React from "react";
import './HeaderNav.css'
import '../Sidebar/SideBar.css'
import {HeaderNavItems} from "../HeaderNav/HeaderNavItems";
import {SideBar} from "../Sidebar/SideBar";
import {Link} from "react-router-dom";

export class HeaderNav extends React.Component {

    state = { clicked: false }

    toggleSideBar = () => {
        this.setState({ clicked: !this.state.clicked})
    }

    render() {
        return (
            <nav className="headerNav">
                <ul className="headerNav-menu">
                    {HeaderNavItems.map((item, index) => {
                        return(
                            <li key={index}>
                                <a className={item.cName} href={item.url} onClick={this.toggleSideBar}>{item.title}</a>

                            </li>

                        )
                    })}
                </ul>
            </nav>
        )
    }


}