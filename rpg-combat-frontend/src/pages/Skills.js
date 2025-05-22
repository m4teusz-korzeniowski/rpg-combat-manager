import { useEffect, useState } from 'react';

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
                console.error('Błąd podczas pobierania skilli:', error);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <p>Ładowanie umiejętności...</p>;
    }

    return (
        <div style={{ padding: '2rem', fontFamily: 'sans-serif' }}>
            <h2>Umiejętności</h2>
            <ul>
                {skills.map(skill => (
                    <li key={skill.id}>{skill.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default Skills;