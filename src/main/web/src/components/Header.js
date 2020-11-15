import React from "react";
import './Header.css'

export class Header extends React.Component {
    render() {
        return (
            <nav>
                <div>
                    <div className="header-wrapper">
                        <table align="horizontal">
                            <thead>
                            <tr>
                                <th>
                                    <button className="header-button">CATEGORIES</button>
                                </th>
                                <th>
                                    <button className="header-button">NEW</button>
                                </th>
                                <th>
                                    <button className="header-button">BASKET</button>
                                </th>
                                <th>
                                    <button className="header-button">LOG IN</button>
                                </th>
                            </tr>

                            </thead>

                        </table>

                    </div>
                </div>
            </nav>
        )
    }


}