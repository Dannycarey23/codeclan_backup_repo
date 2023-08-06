import {useState} from "react";
import { postSighting } from "./SightingService";

const SightingsForm = ({addSighting}) => {
    
    const [formData, setFormData] = useState({
        species: "",
        location: "",
        date: "",
    })

    const onChange = (e) =>{
        const newFormData = Object.assign({}, formData);
        newFormData[e.target.name] = e.target.value;
        setFormData(newFormData);
    }

    const onSubmit = (e) =>{
        e.preventDefault();
        postSighting(formData).then((data)=>{
            addSighting(data);
        })
        // Reset the form input values
        setFormData({
            species: "",
            location: "",
            date: "",
        });
    }

    return (
        <form onSubmit={onSubmit} id="sightings-form" >
            <h2>Add a Sighting</h2>
            <div className="formWrap">
                <label htmlFor="species">Species:</label>
                <input 
                    onChange={onChange} 
                    type="text" 
                    id="species" 
                    name="species"
                    value={formData.species} />
            </div>
            <div className="formWrap">
                <label htmlFor="location">Location:</label>
                <input 
                    onChange={onChange} 
                    type="text" 
                    id="location" 
                    name="location"
                    value={formData.location} />
            </div>
            <div className="formWrap">
                <label htmlFor="date">Date:</label>
                <input 
                    onChange={onChange} 
                    type="date" 
                    id="date" 
                    name="date" 
                    value={formData.date}/>
            </div>

            <input type="submit" value="Save" id="save"/>
	    </form>

    );
}

export default SightingsForm;