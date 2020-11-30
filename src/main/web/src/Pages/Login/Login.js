import React from 'react';

import axios from "axios";
import './Login.css'
import google_icon from './google_qauth.png';
import facebook_icon from './facebook_qauth.png';
import Axios from "axios";

export class Login extends React.Component{

    constructor(props) {
        super(props);
        this.state = this.initialState
        this.submitLoginCredentials = this.submitLoginCredentials.bind(this);
        this.loginCredentials = this.loginCredentials.bind(this);
    }

    initialState = {email: '', password: ''};

    loginCredentials = event => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    submitLoginCredentials = (event) => {
        event.preventDefault()

        const credentials = {
            email: this.state.email,
            password: this.state.password
        };

        const formData = new FormData();
        formData.append('details', JSON.stringify(credentials));

        Axios.post("http://localhost:8080/users/login", formData, {
                headers: {
                    "Content-Type": "multipart/form-data"
                }
            }
        )
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert("User logged in successfully")
                }
            })
    }

    render() {

        const {email, password} = this.state
        return (
                <form id="loginForm" onSubmit={this.submitLoginCredentials}>
                    <div className="loginFormLabel">Log in</div>
                    <input type="text" name="email" id="loginEmail"
                           placeholder="Enter your email"
                           value={email} onChange={this.loginCredentials} required/>
                    <input type="password" name="password" id="loginPassword"
                           placeholder="Enter your password"
                           value={password} onChange={this.loginCredentials} required/>

                    <button className='loginButton' type='submit' onSubmit='requestOptions'>LOG IN</button>
                    <img className="loginQuathIcon" src={google_icon} alt={""}/>
                    <img className="loginQuathIcon" src={facebook_icon} alt={""}/>
                </form>
        )

    }

}