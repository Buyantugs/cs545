import React, { useState } from 'react';

export const MyComponent2 = () => {

    //let counter=0;
   
    const [counter, setCounter]=useState(0);

    const increment = () => {
        setCounter(counter+3);
    }

    const decrement = () => {
        setCounter(counter-3);
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
                        <button onClick={increment}>+3</button> 
                    </td>
                    <td>
                    <button onClick={decrement}>-3</button> 
                    </td>
                </tr>


            </table>
        </div>
    );
}