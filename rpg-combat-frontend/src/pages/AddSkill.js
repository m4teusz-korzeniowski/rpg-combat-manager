import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {Form, Button, Container} from "react-bootstrap";
import {attributeMap} from "../utils/attributeMapper";

function AddSkill() {
    const [name, setName] = useState('');
    const [relatedAttribute, setRelatedAttribute] = useState('');
    const [description, setDescription] = useState('');
    const navigate = useNavigate();
    const [errors, setErrors] = useState({});

    const handleSubmit = (e) => {
        e.preventDefault();

        const newSkill = {
            name,
            relatedAttribute,
            description
        };

        fetch('http://localhost:8080/api/skills', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newSkill)
        })
            .then(async response => {
                if (!response.ok) {
                    const errorData = await response.json();
                    setErrors(errorData);
                    throw new Error('Validation error');
                }
                return response.json();
            })
            .then(() => {
                alert('Dodano nową umiejętność!')
                navigate('/skills')
            })
            .catch(err => console.error("Nie udało się dodać umiejętności: ", err));
    };

    return (
        <Container className="my-4">
            <h2>Dodaj nową umiejętność</h2>
            <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3">
                    <Form.Label>Nazwa</Form.Label>
                    <Form.Control
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        isInvalid={!!errors.name}
                    />
                    <Form.Control.Feedback type="invalid">
                        {errors.name}
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Cecha bazowa</Form.Label>
                    <Form.Control
                        as="select"
                        value={relatedAttribute}
                        onChange={(e) => setRelatedAttribute(e.target.value)}
                        isInvalid={!!errors.relatedAttribute}
                    >
                        {Object.keys(attributeMap)
                            .filter((key) => !['W', 'M'].includes(key))
                            .map((key) => (
                                <option key={key} value={key}>
                                    {attributeMap[key].label}
                                </option>
                            ))}
                    </Form.Control>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Opis</Form.Label>
                    <Form.Control
                        as="textarea"
                        rows={8}
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        isInvalid={!!errors.description}
                    />
                    <Form.Control.Feedback type="invalid">
                        {errors.description}
                    </Form.Control.Feedback>
                </Form.Group>
                <Button type="submit">Dodaj</Button>
            </Form>
        </Container>
    );
}

export default AddSkill;