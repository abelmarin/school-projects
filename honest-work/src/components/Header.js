import React from 'react';
import settingsGear from '../assets/settings.png';

import { NavLink } from 'react-router-dom';

function Header() {
    return (
        <div style={headerStyle}>
            <NavLink to="/" style={logoStyle}>
                <h1>HonestWork</h1>
            </NavLink>
            <NavLink to="/settings">
                <img src={settingsGear} alt="Settings Gear" style={settingsStyle} />
            </NavLink>
            
        </div>
    )
}

const headerStyle = {
    background: '#ECECEC',
    height: '7rem'
}

const logoStyle = {
    color: '#000000',
    padding: '.7rem 3rem',
    float: 'left',
    textDecoration: 'none',
    verticalAlign: 'center'
}

const settingsStyle = {
    height: '50px',
    width: '50px',
    float: 'right',
    padding: '24px 30px',
    margin: 'auto'
}

export default Header;