export default (state, action) => {
    switch(action.type) {
        case 'DELETE_PROJECT':
            return {
                ...state,
                projects: state.projects.filter(project => project.id !== action.payload)
            }
        case 'ADD_PROJECT':
            return {
                ...state,
                projects: [action.payload, ...state.projects]
            }
        case 'DELETE_USER':
            return {
                ...state,
                users: state.users.filter(user => user.id !== action.payload)
            }
        case 'ADD_USER':
            return {
                ...state,
                users: [action.payload, ...state.users]
            }
        case 'NEGATE_LOGGED_IN':
            return {
                ...state,
                isLoggedIn: !state.isLoggedIn
            }
        case 'SET_CURR_USER':
            return {
                ...state,
                currUser: state.user
            }
        case 'DELETE_TASK':
            return {
                ...state,
                tasks: state.tasks.filter(task => task.id !== action.payload)
            }
        case 'ADD_TASK':
            return {
                ...state,
                tasks: [action.payload, ...state.tasks]
            }
        case 'DELETE_COMMENT':
            return {
                ...state,
                comments: state.comments.filter(comment => comment.id !== action.payload)
            }
        case 'ADD_COMMENT':
            return {
                ...state,
                comments: [action.payload, ...state.comments]
            }
        default:
            return state;
    }
}