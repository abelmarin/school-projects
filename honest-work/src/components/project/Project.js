import React, { Component } from 'react';
import { TaskList } from './TaskList';
import { Link } from 'react-router-dom';

import './projectStyle.css';

export default class Project extends Component {
    render() {
        return (
            <div>
                <h1 className="project-header">Project Name</h1>
                <div className="project-btn-container">
                    <Link to='/feedback'><button>Feedback</button></Link>
                    <Link to='/leaderboard'><button>HP Leaderboard</button></Link>
                </div>
                <TaskList initialShowPopup={false} />
            </div>
        )
    }
}
