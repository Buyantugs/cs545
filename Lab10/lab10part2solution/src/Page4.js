import React from 'react';
import {useLocation } from 'react-router-dom';

export const Page4 = () => {
   
    const location = useLocation();
    const firstname = location.state.firstname;
    const lastname = location.state.lastname;
    const profession = location.state.profession;

    const street = location.state.street;
    const city = location.state.city;
    const zip = location.state.zip;
    const state = location.state.state;

    const creditcard = location.state.creditcard;
    const cardtype = location.state.cardtype;


    let page4 = (

        <div>
            <h3>All entered data</h3>
            <div>
                <p>Firstname: {firstname}</p>
                <p>Lastname: {lastname}</p>
                <p>Profession: {profession}</p>
                <p>Street: {street}</p>
                <p>City: {city}</p>
                <p>Zipcode: {zip}</p>
                <p>State: {state}</p>
                <p>Credit Card: {creditcard}</p>
                <p>Type: {cardtype}</p>
                <br />
            </div>
            
        </div>
    )

    return page4;

}