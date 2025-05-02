import React, { useState } from 'react';

export const MyComponent1 = () => {

    //let counter=0;
   
    const [counter, setCounter]=useState(0);

    const increment = () => {
        setCounter(counter+1);
    }

    const decrement = () => {
        setCounter(counter-1);
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
                        <button onClick={increment}>+1</button> 
                    </td>
                    <td>
                    <button onClick={decrement}>-1</button> 
                    </td>
                </tr>


            </table>
        </div>
    );
}