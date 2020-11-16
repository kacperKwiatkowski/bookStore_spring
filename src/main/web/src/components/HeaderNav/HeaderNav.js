import React from "react";
import './HeaderNav.css'
import {HeaderNavItems} from "../HeaderNav/HeaderNavItems";

export class HeaderNav extends React.Component {
    render() {
        return (
            <nav className="headerNav">
                <ul className="headerNav-menu">
                    {HeaderNavItems.map((item, index) => {
                        return(
                            <li key={index}>
                                <a className={item.cName} href={item.url}>{item.title}</a>
                            </li>
                        )
                    })}
                </ul>
            </nav>
        )
    }


}