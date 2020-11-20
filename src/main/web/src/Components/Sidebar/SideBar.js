import React, {useState} from 'react'

import './SideBar.css';
import {SideBarItems} from "./SideBarItems";

export function SideBar() {


    const [sidebar, setSidebar] = useState(false);

    const showSidebar = () => setSidebar(!sidebar);

        return (
            <nav className="sideBar">
                <ul className="sideBar-menu">
                    {SideBarItems.map((item, index) => {
                        return(
                            <li key={index} className="side-link">
                                <a className={item.cName} href={item.url}>{item.title}</a>
                            </li>
                        )
                    })}
                </ul>
            </nav>
        )
}