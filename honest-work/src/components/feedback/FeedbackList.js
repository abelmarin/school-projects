import React, { useState, useContext } from 'react';
import { FeedbackComponent } from './FeedbackComponent';
import { GlobalContext } from '../../context/GlobalState.js';

import './feedbackStyle.css';
import addCircle from '../../assets/addCircle.png';

export const FeedbackList = ({ initialShowPopup }) => {
    const { addComment, comments } = useContext(GlobalContext);

    const [text, setText] = useState('');
    const [subject, setSubject] = useState('');
    const [showPopup, negateShowPopup] = useState(initialShowPopup);

    const onSubmit = e => {
        e.preventDefault();

        const newComment = {
            id: Math.floor(Math.random() * 100000000),
            subject,
            text
        }

        addComment(newComment);
        togglePopup();
    }

    function togglePopup() {
        negateShowPopup(!showPopup);
    }


    return (
        <ul className="feedback-list">
            {comments.map(comment => (<FeedbackComponent key={comment.id} comment={comment} />))} <br/>
            
            <button className="add-feedback" onClick={togglePopup} >
                <img src={addCircle} className="add-feedback-btn" alt="Add Circle" />
                <div>Add Feedback</div>
            </button> <br/>

            {showPopup ? 
                <form className="formStyle" onSubmit={onSubmit}>
                    {/* Subject line */}
                    <label className="labelStyle">Subject</label> <br/><br/>
                    <input 
                        className="subjectStyle"
                        value={subject} 
                        onChange={(e) => setSubject(e.target.value)}  /> <br/><br/>

                    {/* Feedback section */}
                    <label className="labelStyle">Feedback</label><br/><br/>
                    <textarea 
                        className="feedbackStyle"
                        value={text} 
                        onChange={(e) => setText(e.target.value)}  /> <br/><br/><br/>

                    {/* Submit Button */}
                    <button className="submitStyle">Submit</button>
                </form> : null}
        </ul>
            
    )
}
