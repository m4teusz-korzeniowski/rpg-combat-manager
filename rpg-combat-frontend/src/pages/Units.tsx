import {useEffect, useState} from 'react';
import {getUnits} from "../api/unitService";
import {UnitTemplateDto} from "../model/unitTemplate";
import {UnitTemplateTable} from "../components/UnitTemplateTable";
import React from 'react';


function Units(){

    const [units, setUnits] = useState<UnitTemplateDto[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        getUnits()
            .then(data => {
                setUnits(data);
                setLoading(false);
            })
            .catch(err => {
                console.error('Error', err);
                setLoading(false);
            })
    }, []);

    if(loading){
        return <p>Ładownie...</p>;
    }

    return (
        <div>
            {units.map( unit => (
                <UnitTemplateTable key={unit.id} unitTemplate={unit}/>
            ))}
        </div>
    )
}

export default Units;