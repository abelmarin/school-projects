import React, { createContext, useReducer } from 'react';
import AppReducer from './AppReducer';

// Initial state
const initialState = {
    users: [],
    projects: [],
    tasks: [],
    comments: [],
    isLoggedIn: false,
    currUser: {}
}

// Create context
export const GlobalContext = createContext(initialState);

// Provider component
export const GlobalProvider = ({ children }) => {
    const [state, dispatch] = useReducer(AppReducer, initialState);

    // Actions for home page
    function deleteProject(id) {
        dispatch({
            type: 'DELETE_PROJECT',
            payload: id
        });
    }

    function addProject(project) {
        dispatch({
            type: 'ADD_PROJECT',
            payload: project
        });
    }

    function negateLoggedIn() {
        dispatch({
            type: "NEGATE_LOGGED_IN"
        });
    }

    function setCurrUser(user) {
        dispatch({
            type: 'SET_CURR_USER',
            payload: user
        });
    }

    // Actions for users
    function deleteUser(id) {
        dispatch({
            type: 'DELETE_USER',
            payload: id
        });
    }

    function addUser(user) {
        dispatch({
            type: 'ADD_USER',
            payload: user
        });
    }


    // Actions for Project page
    function deleteTask(id) {
        dispatch({
            type: 'DELETE_TASK',
            payload: id
        });
    }

    function addTask(task) {
        dispatch({
            type: 'ADD_TASK',
            payload: task
        });
    }

    // Actions for Feedback page
    function deleteComment(id) {
        dispatch({
            type: 'DELETE_COMMENT',
            payload: id
        });
    }

    function addComment(comment) {
        dispatch({
            type: 'ADD_COMMENT',
            payload: comment
        });
    }

    return (<GlobalContext.Provider value={{
        users: state.users,
        projects: state.projects,
        tasks: state.tasks,
        comments: state.comments,
        isLoggedIn: state.isLoggedIn,
        currUser: state.currUser,
        deleteProject,
        addProject,
        deleteUser,
        addUser,
        deleteTask,
        addTask,
        deleteComment,
        addComment,
        negateLoggedIn,
        setCurrUser
    }}>
        {children}
    </GlobalContext.Provider>);
}