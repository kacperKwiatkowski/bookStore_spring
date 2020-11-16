import React from 'react';
import './Register.css';

export function Register() {
    return (
        <div className='register'>
            <form id="registerForm">
                <div className="registerFormLabel">Sign in</div>
                <input type="text" name="email" id="registerEmail"/>
                <input type="password" name="password" id="registerPassword"/>
                <input type="password" name="passwordVerification" id="registerPasswordVerification"/>
                <input type="text" name="firstName" id="registerEmail"/>
                <input type="text" name="lastName" id="registerPassword"/>
            </form>
        </div>
    );
}

export default Register;