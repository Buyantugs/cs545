import { useSelector, useDispatch } from "react-redux";
import { useState } from "react";

export const Calculator = () => {

    const dispatch = useDispatch();
    const result = useSelector(state => state.result);

    const [number1, setNumber1] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [operator, setOperator] = useState("");

    const handleCalc = e => {
        e.preventDefault();
        
        dispatch({
            type: operator,
            number1: Number(number1),
            number2: Number(number2)
        });
        
    }

    return (
        <div>
            <h1>Calculator</h1>
            <table border={1}>
                <tbody>
                    <tr>
                        <td>First number</td>
                        <td><input
                            type="number"
                            value={number1}
                            onChange={e => { setNumber1(e.target.value) }} >
                        </input></td>
                    </tr>
                    <tr>
                        <td>Operator</td>
                        <td><select value={operator} onChange={e => setOperator(e.target.value)}>
                            <option value="">Select</option>
                            <option value="add">add</option>
                            <option value="subtract">subtract</option>
                            <option value="multiply">multiply</option>
                            <option value="divide">divide</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Second number</td>
                        <td><input
                            type="number"
                            value={number2}
                            onChange={e => { setNumber2(e.target.value) }} >
                        </input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button onClick={handleCalc}>Submit</button></td>
                    </tr>
                </tbody>
            </table>
            <br />
            Result: {result}
        </div>
    );
}
