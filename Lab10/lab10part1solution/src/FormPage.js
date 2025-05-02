import React, { useState } from 'react';

export const FormPage = () => {
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [zip, setZip] = useState('');
    const [state, setState] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [eyecolor, setEyecolor] = useState('');
    const [hobbies, setHobbies] = useState([]);

    const handleHobbyChange = (e) => {
        const { value, checked } = e.target;

        if (checked) {
            
            setHobbies([...hobbies, value]);
        } else {
            
            setHobbies(hobbies.filter(hobby => hobby !== value));
        }
    };


    let formpage = (
        <form>
            <h3>Enter your information</h3>
            <div>
                <input type="text" placeholder='Fisrtname' value={firstname} onChange={e => setFirstname(e.target.value)} />
                <br />
                <input type="text" placeholder='Lastname' value={lastname} onChange={e => setLastname(e.target.value)} />
                <br />
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
                    <option>IL</option>
                    <option>TX</option>
                    <option>AI</option>
                </select>
                <br />
                <input type="text" placeholder='Email' value={email} onChange={e => setEmail(e.target.value)} />
                <br />
                <input type="text" placeholder='phone' value={phone} onChange={e => setPhone(e.target.value)} />
                <br />
                <span>Black</span>
                <input
                    type='radio'
                    value="Black"
                    checked={eyecolor === "Black"}
                    onChange={e => setEyecolor(e.target.value)}
                />
                <span>Blue</span>
                <input
                    type='radio'
                    value="Blue"
                    checked={eyecolor === "Blue"}
                    onChange={e => setEyecolor(e.target.value)}
                />
                <br />
                <span>Soccer</span>
                <input
                    type='checkbox'
                    value='Soccer'
                    checked={hobbies.includes('Soccer')}
                    onChange={handleHobbyChange}
                />

                <span>Basketball</span>
                <input
                    type='checkbox'
                    value='Basketball'
                    checked={hobbies.includes('Basketball')}
                    onChange={handleHobbyChange}
                />

                <span>Cyber game</span>
                <input
                    type='checkbox'
                    value='Cybergame'
                    checked={hobbies.includes('Cybergame')}
                    onChange={handleHobbyChange}
                />

            </div>
            <div>
                <p>Firstname = {firstname}</p>
                <p>Lastname = {lastname}</p>
                <p>Street = {street}</p>
                <p>City = {city}</p>
                <p>Zipcode = {zip}</p>
                <p>State = {state}</p>
                <p>Email = {email}</p>
                <p>Phone = {phone}</p>
                <p>Eye Color = {eyecolor}</p>
                <p>Hobbies = {hobbies.join(', ')}</p>

            </div>
        </form>
    )

    return formpage;

}