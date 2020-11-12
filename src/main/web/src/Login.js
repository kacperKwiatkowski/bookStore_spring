import React from "react";

function Login() {
    return (
        <div className="Login">
            <form id="logging-form">
                <label htmlFor=email>EMAIL</label>
                <input id="email" type="email" onClick="keepForm()"></input>
                    <label htmlFor="email">PASSWORD</label>
                    <input id="password" type="password"></input>
                        <div id="button-wrapper">
                            <a href="logging.html">
                                <img className="qauth-icon" src="google_qauth.png"></img>
                            </a>
                            <a href="logging.html">
                                <img className="qauth-icon" src="facebook_qauth.png"></img>
                            </a>
                            <button type="submit">LOGIN</button>
                            <button type="reset">RESET</button>
                        </div>
            </form>
        </div>
    );
}