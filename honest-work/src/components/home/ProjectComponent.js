import { Link } from 'react-router-dom';
import React, { useContext } from 'react';

import './homeStyle.css';

import { GlobalContext } from '../../context/GlobalState.js';


export const ProjectComponent = ({ project }) => {
    return (
            <Link to="/project" className="project-component">
                {project.text}
            </Link>
    );
};
