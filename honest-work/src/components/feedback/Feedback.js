import React, { Component } from 'react';
import { FeedbackList } from './FeedbackList';

import './feedbackStyle.css';

export default class Feedback extends Component {


    render() {
        return (
            <div>
                <h1 className="header-style">List of Feedback</h1>
                <FeedbackList initialShowPopup={false} />
            </div>
        )
    }
}
