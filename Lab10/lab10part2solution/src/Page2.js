import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Page2 = () => {

    const navigate = useNavigate();
    const location = useLocation();
    const firstname = location.state.firstname;
    const lastname = location.state.lastname;
    const profession = location.state.profession;

    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [zip, setZip] = useState('');
    const [state, setState] = useState('');

    const goToNextPage = () => {
        navigate('/page3', { state: { firstname: firstname, lastname: lastname, profession: profession, street: street, city: city, zip: zip, state: state } })
    }

    let page2 = (

        <div>
            <div>
                <p>Firstname: {firstname}</p>
                <p>Lastname: {lastname}</p>
                <p>Profession: {profession}</p>
                <br/>
            </div>
            <div>
                <input type="text" placeholder='Street' value={street} onChange={e => setStreet(e.target.value)} />
                <br />
                <input type="text" placeholder='City' value={city} onChange={e => setCity(e.target.value)} />
                <br />
                <input type="text" placeholder='Zipcode' value={zip} onChange={e => setZip(e.target.value)} />
                <br />
                <select
                    type="text"
                    value={state}
                    onChange={e => setState(e.target.value)}>
                    <option>CA</option>
                    <option>TX</option>
                    <option>AI</option>
                </select>
                <br />
                <button onClick={goToNextPage}>Next</button>
            </div>
        </div>
    )

    return page2;

}