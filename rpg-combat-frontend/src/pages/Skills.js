import {useEffect, useState} from 'react';
import { formatAttribute } from '../utils/attributeMapper';

function Skills() {
    const [skills, setSkills] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/api/skills')
            .then(response => response.json())
            .then(data => {
                setSkills(data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Error', error);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <p>Ładowanie...</p>;
    }

    return (
        <div className="container p-1 my-1 bg-light rounded shadow-sm">
            <h2>Umiejętności</h2>
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Nazwa:</th>
                    <th>Cecha:</th>
                    <th>Opis:</th>
                </tr>
                </thead>
                <tbody>
                {skills.map(skill => (
                    <tr key={skill.id}>
                        <td>
                            {skill.name}
                        </td>
                        <td>
                            {formatAttribute(skill.relatedAttribute, 'label')}
                        </td>
                        <td>
                            {skill.description}
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Skills;