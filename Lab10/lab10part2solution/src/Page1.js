import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom';

export const Page1=()=>{

    const navigate=useNavigate();

    const [firstname, setFirstname]=useState('');
    const [lastname, setLastname]=useState('');
    const [profession, setProfession]=useState('');

    const goToNextPage=()=>{
        navigate('/page2', {state:{firstname:firstname, lastname:lastname, profession:profession}})
    }

    let page1=(
        
        <div>
       
            <input type='text' placeholder='firstname' value={firstname} onChange={e=>setFirstname(e.target.value)}/>
            <br/>
            <input type='text' placeholder='lastname' value={lastname} onChange={e=>setLastname(e.target.value)}/>
            <br/>
            <select type='text' value={profession} onChange={e=>setProfession(e.target.value)}>
                <option>Programmer</option>
                <option>Tester</option>
                <option>Manager</option>
                <option>Architect</option>
            </select>
            <br/>
            <button onClick={goToNextPage}>Next</button>
       
        </div>
    )

    return page1;

}