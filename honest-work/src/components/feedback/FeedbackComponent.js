import React, { useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState.js';


import './feedbackStyle.css';

export const FeedbackComponent = ({ comment }) => {
    const { users } = useContext(GlobalContext);

    return (
        <div className="feedback-component-wrapper">
            <h2>{comment.subject}</h2>
            <p>{comment.text}</p>
        </div>
    );
};
