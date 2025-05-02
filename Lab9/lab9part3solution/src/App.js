import './App.css';
import {MyComponent1} from './MyComponent1';
import {MyComponent2} from './MyComponent2';
import {MyComponent3} from './MyComponent3';
import {MyComponent4} from './MyComponent4';


function App() {

  return (
    <table>
      <tr>
        <td><MyComponent1/></td>        
        <td><MyComponent2 /></td>        
      </tr>      
      <tr>
        <td><MyComponent3/></td>        
        <td><MyComponent4 /></td>        
      </tr>      
    </table>
  );
}

export default App;