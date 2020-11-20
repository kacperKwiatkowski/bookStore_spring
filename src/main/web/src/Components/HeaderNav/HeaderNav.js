import React, {useState} from "react";
import './HeaderNav.css'
import '../Sidebar/SideBar.css'
import {HeaderNavItems} from "./HeaderNavItems";
import {SideBar} from "../Sidebar/SideBar";
import {Link} from "react-router-dom";
import {SideBarItems} from "../Sidebar/SideBarItems";

export class HeaderNav extends React.Component{

    state = { clicked: false }

    handleClick = () => {
        this.setState({ clicked: !this.state.clicked})
    }

    render() {
        return (
            <>
                <nav className="headerNav">
                    <ul className="headerNav-menu">
                        {HeaderNavItems.map((item, index) => {
                            return (
                                <li key={index}>
                                    <a className={item.cName} href={item.url} onMouseUp={this.handleClick}>{item.title}</a>

                                    <div className={this.state.clicked ? `dropdown-menu active` : `dropdown-menu disabled`}>
                                        {SideBarItems.map((item, index) => {
                                            return(
                                                <li key={index} className="side-link">
                                                    <a className={item.cName} href={item.url}>{item.title}</a>
                                                </li>
                                            )
                                        })}
                                    </div>
                                </li>
                            )
                        })}
                    </ul>
                </nav>
            </>
        );
    }


}
