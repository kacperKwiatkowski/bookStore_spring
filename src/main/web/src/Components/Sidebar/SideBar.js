import React from 'react'

import './SideBar.css';
import {SideBarItems} from "./SideBarItems";

export class SideBar extends React.Component{
    render() {
        return (
            <nav className="sideBar">
                <ul className="sideBar-menu">
                    {SideBarItems.map((item, index) => {
                        return(
                            <li key={index} className={item.cName}>
                                <a className={item.cName} href={item.url}>{item.title}</a>
                            </li>
                        )
                    })}
                </ul>
            </nav>
        )
    }
}