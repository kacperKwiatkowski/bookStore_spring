import React from 'react';
import './Login.css'
import google_icon from './google_qauth.png';
import facebook_icon from './facebook_qauth.png';

export function Login() {

    

    return (
        <div>
            <form id="loginForm">
                <div className="loginFormLabel">Log in</div>
                <input type="text" name="email" id="loginEmail"/>
                <input type="password" name="password" id="loginPassword"/>
                <img className="loginQuathIcon" src={google_icon} alt={""}/>
                <img className="loginQuathIcon" src={facebook_icon} alt={""}/>
            </form>
        </div>
    )
}

export default Login;