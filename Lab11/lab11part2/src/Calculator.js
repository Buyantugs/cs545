import { useState } from "react"

export const Calculator = () => {

    const [number1, setNumber1] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [operator, setOperator] = useState("");
    const [result, setResult] = useState("");

    const handleCalc = e => {

        if (operator === "add")
            setResult(number1 + number2);
        else if (operator === "subtract") {
            setResult(number1 - number2);
        }
        else if (operator === "multiply") {
            setResult(number1 * number2);
        } else {
            setResult(number1 / number2);
        }

        e.preventDefault();
    }

    return (
        <div>
            <h1>Calculator</h1>
            <table border={1}>
                <tbody>
                    <tr>
                        <td>Fist number</td>
                        <td><input
                            type="text"
                            value={number1}
                            onChange={e => { setNumber1(e.target.value) }} >
                        </input></td>
                    </tr>
                    <tr>
                        <td>Operator</td>
                        <td><select type="text" name="operator" value={operator} onChange={e => setOperator(e.target.value)}>
                            <option>add</option>
                            <option>subtract</option>
                            <option>multiply</option>
                            <option>divide</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Second number</td>
                        <td><input
                            type="text"
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
            Result:{result}
        </div>
    )

} 