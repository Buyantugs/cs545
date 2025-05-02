import React from 'react';

export const MyComponent = (props) => {


    let message="Hello from button"

    const displayAlert = () => {
        alert(`Hello from button- ${props.buttonNo}`);
    }

    return (
        <div>
            <header>
                <p>
                    <button onClick={displayAlert}>{message} {props.buttonNo}</button>
                </p>
            </header>
        </div>
    );
}