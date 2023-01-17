import React, { useState, useContext } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState.js';

import './homeStyle.css';
import stringsToHash from '../../scripts/hash';

export const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const history = useHistory();

    const { users, negateLoggedIn, addUser } = useContext(GlobalContext);

    function validateForm() {
        return !(username.length > 0 && password.length > 0);
    }

    const checkUserExists = function(hash) {
        for(var i =0; i < users.length; i++) {
            if (users[i].id === hash) {
                return true;
            }
        }
        return false;
    }

    const onSubmit = e => {
        e.preventDefault();

        var hash = stringsToHash(username,password);

        if (checkUserExists(hash)) {
            negateLoggedIn();
        }

    }


    return (
        <div className="login">
            <h1>Login</h1>
            <form onSubmit={onSubmit} className="login-form">
                <label>Username:</label>
                <input type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} />
                <label>Password:</label>
                <input type="text"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} />
                <button className="login-btn" disabled={validateForm()}>Login</button>
            </form>
            <h3>Not a user? Register here:</h3>
            <Link to="register" className="register-link">Sign up!</Link>
        </div>
    );
};