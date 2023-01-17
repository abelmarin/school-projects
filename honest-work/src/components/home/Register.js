import React, { useState, useContext } from 'react';
import { useHistory  } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState.js';

import './homeStyle.css';
import stringsToHash from '../../scripts/hash';

export const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const history = useHistory();

    const { users, addUser, negateLoggedIn } = useContext(GlobalContext);

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

        var honestPointsCounter = 0;

        if (checkUserExists(hash)) {
            negateLoggedIn();
            history.push("/");
        }

        const newUser = {
            id: hash,
            username,
            password,
            honestPointsCounter
        }

        addUser(newUser);
        negateLoggedIn();
        history.push("/");console.log(users);
    }

    return (
        <div className="register">
            <h1>Create Your Account!</h1>
            <form onSubmit={onSubmit} className="register-form">
                <label>Username:</label>
                <input type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} />
                <label>Password:</label>
                <input type="text"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} />
                <button className="register-btn" disabled={validateForm()}>Sign up!</button>
            </form>
            
        </div>
    );
};

export default Register;