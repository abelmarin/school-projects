import React, { Component } from 'react';

import './settingsStyle.css';
import cross from '../../assets/cross.png';

import { NavLink } from 'react-router-dom';

export default class Settings extends Component {
    render() {
        return (
            <div className="settingsContainer">
                <NavLink to="/">
                    <img src={cross} alt="Cross" className="crossStyle" />
                </NavLink>
                <h1>Account</h1><br/>
                <a href="#">Change Profile Picture</a><br/><br/>
                <a href="#">Change Password</a><br/><br/>
                <a href="#" className="deleteStyle">Delete Account</a>
            </div>
        )
    }
}
