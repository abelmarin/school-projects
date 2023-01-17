import React from 'react';
 
const Error = () => {
    return (
       <div>
          <p style={errorStyle}>Error: Page does not exist!</p>
       </div>
    );
}

const errorStyle = {
   textAlign: 'center'
}
 
export default Error;
