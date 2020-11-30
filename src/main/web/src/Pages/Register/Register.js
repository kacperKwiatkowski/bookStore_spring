import React from 'react';
import './Register.css';
import Axios from "axios";

export class Register extends React.Component{

    constructor(props) {
        super(props);
        this.state = this.initialState
        this.submitRegisterCredentials = this.submitRegisterCredentials.bind(this);
        this.registerCredentials = this.registerCredentials.bind(this);
    }

    initialState = {email: '', password: '', repeatedPassword: '', firstname: '', lastname: ''};

    registerCredentials = event => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    submitRegisterCredentials = (event) => {
        event.preventDefault()

        const credentials = {
            email: this.state.email,
            password: this.state.password,
            repeatedPassword: this.state.repeatedPassword,
            firstname: this.state.firstname,
            lastname: this.state.lastname
        };

        const formData = new FormData();
        formData.append('details', JSON.stringify(credentials));

        Axios.post("http://localhost:8080/users/register", formData, {
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

        const {email, password, repeatedPassword, firstname, lastname} = this.state

        return (
                <form id="registerForm" onSubmit={this.submitRegisterCredentials}>
                    <div className="registerFormLabel">Sign in</div>
                    <input type="email" name="email"
                           placeholder="Enter your email"
                           value={email}  onChange={this.registerCredentials} required/>
                    <input type="password" name="password"
                           placeholder="Enter your password"
                           value={password}  onChange={this.registerCredentials} required/>
                    <input type="password" name="repeatedPassword" id="registerPasswordVerification"
                           placeholder="Repeat your password"
                           value={repeatedPassword}  onChange={this.registerCredentials} required/>
                    <input type="text" name="firstname"
                           placeholder="Enter your first name"
                           value={firstname}  onChange={this.registerCredentials} required/>
                    <input type="text" name="lastname"
                           placeholder="Enter your last name"
                           value={lastname}  onChange={this.registerCredentials} required/>

                    <button className='signInButton' type='submit' onSubmit='requestOptions'>SIGN IN</button>
                </form>
        );
    }
}

export default Register;