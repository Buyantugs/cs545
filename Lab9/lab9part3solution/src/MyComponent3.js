import React, { useState } from 'react';

export const MyComponent3 = () => {

    //let counter=0;
   
    const [counter, setCounter]=useState(0);

    const increment = () => {
        setCounter(counter+5);
    }

    const decrement = () => {
        setCounter(counter-5);
    }

    return (
        <div>
            <table>
                <tr>
                    <td>
                        <h3>
                             {counter}
                        </h3>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td> 
                        <button onClick={increment}>+5</button> 
                    </td>
                    <td>
                    <button onClick={decrement}>-5</button> 
                    </td>
                </tr>


            </table>
        </div>
    );
}