import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

export const Page3 = () => {

    const navigate = useNavigate();
    const location = useLocation();
    const firstname = location.state.firstname;
    const lastname = location.state.lastname;
    const profession = location.state.profession;

    const street = location.state.street;
    const city = location.state.city;
    const zip = location.state.zip;
    const state = location.state.state;

    const [creditcard, setCreditcard] = useState('');
    const [cardtype, setCardtype] = useState('');


    const goToNextPage = () => {
        navigate('/page4', { state: { firstname: firstname, lastname: lastname, profession: profession, street: street, city: city, zip: zip, state: state, creditcard: creditcard, cardtype: cardtype } })
    }

    let page3 = (

        <div>
            <div>
                <p>Firstname: {firstname}</p>
                <p>Lastname: {lastname}</p>
                <p>Profession: {profession}</p>
                <p>Street: {street}</p>
                <p>City: {city}</p>
                <p>Zipcode: {zip}</p>
                <p>State: {state}</p>
                <br />
            </div>
            <div>
                <input type='text' placeholder='Credit Card' value={creditcard} onChange={e => setCreditcard(e.target.value)} />
                <br />
                <span>Visa</span>
                <input
                    type='radio'
                    value="Visa"
                    checked={cardtype === "Visa"}
                    onChange={e => setCardtype(e.target.value)}
                />
                <span>Master</span>
                <input
                    type='radio'
                    value="Master"
                    checked={cardtype === "Master"}
                    onChange={e => setCardtype(e.target.value)}
                />
                <br />
                <button onClick={goToNextPage}>Next</button>

            </div>
        </div>
    )

    return page3;

}