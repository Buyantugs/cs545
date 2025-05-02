import React, { useState } from "react"
import axios from 'axios';

export const BankAccounts = () => {
    const cleaner = { accountNumber: "", accountHolder: "", balance: 0, transactions: [] }
    const [account, setAccount] = useState(cleaner);
    const [accounts, setAccounts] = useState([]);
    const [accountnumber, setAccountnumber] = useState("");
    const [accountholder, setAccountholder] = useState("");

    const loadAccounts = () => {

        const accounts = axios.get("http://localhost:8080/bank/getAccounts")
            .then((response) => {

                console.log(response.data);
                setAccounts(response.data);
            });
    }

    

    const loadAccount = (accountnumber) => {

        const account = axios.get("http://localhost:8080/bank/getAccount/" + accountnumber)
            .then((response) => {

                console.log(response.data);
                setAccount(response.data);
            });
    }

    const addAcount = (account) => {
        axios.post("http://localhost:8080/bank/createAccount", account)
            .then((response) => {
                loadAccounts();
            })
    }

    const deleteAcount = (e) => {
        console.log(e.target.value);

        axios.delete("http://localhost:8080/bank/remove/"+ e.target.value)        
            .then((response) => {
                loadAccounts();
            })
    }


    React.useEffect(() => {
        loadAccounts();
    }, []);
    

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log("handle Submit");
        if(account){
            console.log("call server...");
            addAcount(account);
        }
    }

    const handleFieldChange=(e)=>{
        setAccount({...account,[e.target.name]: e.target.value});
    }

    return (
        <div>

            <div>
                <h2>Search Account</h2>
                <input type="text"
                    placeholder="Account Number"
                    value={accountnumber}
                    onChange={e => setAccountnumber(e.target.value)}></input>
                <button onClick={e => loadAccount(accountnumber)}>Search</button>

                <p>Result: {account.accountNumber} {account.accountHolder}</p>
            </div>
            <span></span>

            <div>
                <h1>Bank Accounts</h1>
                <table border={1}>
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Account Holder</th>
                            <th>Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        {accounts.map(account => (
                            <tr key={account.accountNumber}>
                                <td>{account.accountNumber}</td>
                                <td>{account.accountHolder}</td>
                                <td>{account.balance}</td>
                                <td><button value={account.accountNumber}>Show Txn</button> </td>
                                <td><button onClick={deleteAcount} value={account.accountNumber}>Delete</button> </td>
                            </tr>
                        ))

                        }
                    </tbody>
                </table>


            </div>

            <div>
                <h2>Add new Bank Account</h2>
                <input type="text" name="accountNumber" placeholder="Account Number" value={account.accountNumber} onChange={handleFieldChange} ></input>
                <br></br>
                <input type="text" name="accountHolder" placeholder="Account Holder" value={account.accountHolder} onChange={handleFieldChange} ></input>
                <br/>
                <button type="submit" onClick={handleSubmit}>Add Account</button>
                
            </div>
        </div>
    );

}