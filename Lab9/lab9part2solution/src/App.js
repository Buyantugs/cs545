import './App.css';
import {MyComponent} from './Component';


function App() {

  return (
    <table>
      <tr>
        <td><MyComponent buttonNo={1}/></td>
        <td><MyComponent buttonNo={2}/></td>
      </tr>
      <tr>
        <td><MyComponent buttonNo={3}/></td>
        <td><MyComponent buttonNo={4}/></td>
      </tr>
    </table>
  );
}

export default App;
