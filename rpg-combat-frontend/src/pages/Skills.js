import {useEffect, useState} from 'react';
import {formatAttribute} from '../utils/attributeMapper';
import Button from "react-bootstrap/Button";
import {Link} from "react-router-dom";
import {getSkills} from "../api/skillService";
import {DeleteSkillButton} from "../components/DeleteSkillButton";

function Skills() {
    const [skills, setSkills] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        getSkills()
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
        <>
            <div className="container mb-3 p-1 my-1 bg-light rounded shadow-sm">
                <Link to="/">Strona główna</Link>
            </div>
            <div className="container p-1 my-1 bg-light rounded shadow-sm">
                <h2>Umiejętności</h2>
                <table className="table table-bordered">
                    <thead className="table-header">
                    <tr>
                        <th>Nazwa:</th>
                        <th>Cecha:</th>
                        <th>Działanie:</th>
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
                                <Link to={`/skills/edit/${skill.id}`}>
                                    <Button className="btn btn-warning">Edytuj</Button>
                                </Link>

                                <DeleteSkillButton
                                    skillId={skill.id}
                                    onDeleted={(id) =>
                                        setSkills(prev => prev.filter(s => s.id !== id))
                                    }
                                />
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <Link to="/skills/add">
                    <Button variant="primary">Dodaj umiejętność</Button>
                </Link>
            </div>
        </>
    );
}

export default Skills;