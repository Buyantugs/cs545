import { useState } from 'react';
import './App.css';
import { MyComponent } from './MyComponent';

function App() {
  const [total, setTotal] = useState(0);

  return (
    <table>
      <tbody>
        <tr>
          <td><MyComponent counter={1} total={total} setTotal={setTotal} /></td>
          <td><MyComponent counter={3} total={total} setTotal={setTotal} /></td>
        </tr>
        <tr>
          <td><MyComponent counter={5} total={total} setTotal={setTotal} /></td>
          <td><MyComponent counter={8} total={total} setTotal={setTotal} /></td>
        </tr>
      </tbody>
    </table>
  );
}

export default App;
