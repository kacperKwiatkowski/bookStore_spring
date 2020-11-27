import React from 'react';
import './Contact.css'

export function Contact() {
    return (
        <div className='contactSiteWrapper'>
            <div className='contactBar'>
                <ul>
                    <li>
                        Email us
                    </li>
                    <li>
                        Call us
                    </li>
                </ul>
            </div>
            <div className='contactPanel'>
                <form>
                    <input type='textBox'/>
                </form>
            </div>
        </div>
    );
}

export default Contact;