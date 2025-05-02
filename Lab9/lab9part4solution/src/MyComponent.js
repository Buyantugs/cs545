import React from 'react';

export const MyComponent = ({ counter, total, setTotal }) => {
  
  const increment = () => {
    setTotal(total+counter);
  };

  const decrement = () => {
    setTotal(total-counter);
  };

  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>
              <h3>{total}</h3>
            </td>
            <td></td>
          </tr>
          <tr>
            <td>
              <button onClick={increment}>+{counter}</button>
            </td>
            <td>
              <button onClick={decrement}>-{counter}</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};
