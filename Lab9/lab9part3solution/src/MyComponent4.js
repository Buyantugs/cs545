import React, { useState } from 'react';

export const MyComponent4 = () => {

    //let counter=0;
   
    const [counter, setCounter]=useState(0);

    const increment = () => {
        setCounter(counter+8);
    }

    const decrement = () => {
        setCounter(counter-8);
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
                        <button onClick={increment}>+8</button> 
                    </td>
                    <td>
                    <button onClick={decrement}>-8</button> 
                    </td>
                </tr>


            </table>
        </div>
    );
}