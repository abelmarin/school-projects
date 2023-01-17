import React, { useState, useContext } from 'react';
import { TaskComponent } from './TaskComponent';
import { GlobalContext } from '../../context/GlobalState.js';

import './projectStyle.css';
import addCircle from '../../assets/addCircle.png';

export const TaskList = ({ initialShowPopup }) => {
    const { addTask, tasks } = useContext(GlobalContext);

    const [text, setText] = useState('');
    const [showPopup, negateShowPopup] = useState(initialShowPopup);

    const onSubmit = e => {
        e.preventDefault();

        const newTask = {
            id: Math.floor(Math.random() * 100000000),
            text
        }

        addTask(newTask);
        togglePopup();
    }


    function togglePopup() {
        negateShowPopup(!showPopup);
    }
    

    return (
        <ul className="project-list">
            {tasks.map(task => (<TaskComponent key={task.id} task={task} />))}
            
            <button className="add-task" onClick={togglePopup}>
                <img src={addCircle} alt="Add Circle" className="add-task-btn" />
                <div>Add New Task</div>
            </button>
            
            {showPopup ? 
                <div>
                    <span className="close" onClick={togglePopup}>&times;</span>
                    <form onSubmit={onSubmit}>
                        <h3>Add New Task</h3>
                        <div className="form-control">
                            <label htmlFor="text">Task Name: </label>
                            <input type="text" value={text} onChange={(e) => setText(e.target.value)} placeholder="Enter text..." />
                        </div>
                        <button className="btn">Add Task</button>
                    </form>
                </div> : null}
        </ul>

    )
}
