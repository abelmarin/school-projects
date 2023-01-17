import React, { useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState.js';


import './feedbackStyle.css';

export const Leaderboard = () => {
    const { users } = useContext(GlobalContext);


        return (
            <div className="leaderboard">
                <h1 className="headerStyle">HonestPoint Leaderboard</h1>

                <table>
                    <tr>
                        <th>
                            Pos
                        </th>
                        <th>
                            User
                        </th>
                        <th>
                            Points
                        </th>
                    </tr>
                    <tr>
                        <th>
                            1
                        </th>
                        <th>
                            Steven Bell
                        </th>
                        <th>
                            29
                        </th>
                    </tr>
                    
                    <tr>
                        <th>
                            2
                        </th>
                        <th>
                            Sara Jones
                        </th>
                        <th>
                            25
                        </th>
                    </tr>
                    <tr>
                        <th>
                            3
                        </th>
                        <th>
                            Michael Phoenix
                        </th>
                        <th>
                            23
                        </th>
                    </tr>
                    <tr>
                        <th>
                            4
                        </th>
                        <th>
                            Joe Biden
                        </th>
                        <th>
                            20
                        </th>
                    </tr>
                    <tr>
                        <th>
                            5
                        </th>
                        <th>
                            Donald Trump
                        </th>
                        <th>
                            17
                        </th>
                    </tr>
                    <tr>
                        <th>
                            6
                        </th>
                        <th>
                            Phillip K. Dick
                        </th>
                        <th>
                            14
                        </th>
                    </tr>
                </table>

            </div>
        )
    
}

export default Leaderboard;