import React, { useState, useContext } from 'react';
import { ProjectComponent } from './ProjectComponent';
import { GlobalContext } from '../../context/GlobalState.js';

import './homeStyle.css';
import addCircle from '../../assets/addCircle.png';

export const ProjectsList = ({ initialShowPopup }) => {
    const { projects, addProject } = useContext(GlobalContext);

    const [text, setText] = useState('');
    const [showPopup, negateShowPopup] = useState(initialShowPopup);

    const onSubmit = e => {
        e.preventDefault();

        const newProject = {
            id: Math.floor(Math.random() * 100000000),
            text
        }

        addProject(newProject);
        togglePopup();
    }

    function togglePopup() {
        negateShowPopup(!showPopup);
    }

    return (
        <ul className="project-list">
            {projects.map(project => (<ProjectComponent key={project.id} project={project} />))}
                
            <button className="add-project" onClick={togglePopup} >
                <img src={addCircle} className="add-project-btn" alt="Add Circle" />
                <div>Create New Project</div>
            </button>

            {showPopup ? 
                <div>
                    <span className="close" onClick={togglePopup}>&times;</span>
                    <form onSubmit={onSubmit}>
                        <h3>Add new Project</h3>
                        <div className="form-control">
                            <label htmlFor="text">Project Name: </label>
                            <input type="text" value={text} onChange={(e) => setText(e.target.value)} placeholder="Enter text..." />
                        </div>
                        <button className="create-project-btn">Create New Project</button>
                    </form>
                </div> : null}
        </ul>
       
    )
}
