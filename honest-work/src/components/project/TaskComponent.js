import { Link } from 'react-router-dom';
import React, { useContext } from 'react';

import './projectStyle.css';

import { GlobalContext } from '../../context/GlobalState.js';


export const TaskComponent = ({ task }) => {
    const { deleteTask } = useContext(GlobalContext);

    return (
            <h1 className="task-component">
                {task.text}
            </h1>
    );
};
