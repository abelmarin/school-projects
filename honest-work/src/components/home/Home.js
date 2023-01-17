import React, { useContext } from 'react';
import { ProjectsList } from './ProjectsList';
import { Login } from './Login';

import './homeStyle.css';

import { GlobalContext } from '../../context/GlobalState.js';

export const Home = () => {
    const { isLoggedIn } = useContext(GlobalContext);

    if (isLoggedIn) {
        return (
            <div>
                <h1 className="header-style">List of Projects</h1>
                <ProjectsList initialShowPopup={false} />
            </div>
        )
    } else {
        return (
            <Login />
        )
    }
    
}

export default Home;