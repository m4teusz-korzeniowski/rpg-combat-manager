import {useEffect, useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import {Form, Button, Container} from "react-bootstrap";
import {attributeMap} from "../utils/attributeMapper";
import {editSkill} from "../api/skillService"
import {getSkill} from "../api/skillService";
import {useParams} from "react-router-dom";

function EditSkill() {
    const {id} = useParams();
    const [name, setName] = useState('');
    const [relatedAttribute, setRelatedAttribute] = useState('');
    const [description, setDescription] = useState('');
    const [errors, setErrors] = useState({});
    const navigate = useNavigate();

    useEffect(() => {
        getSkill(id)
            .then(skill => {
                setName(skill.name);
                setRelatedAttribute(skill.relatedAttribute);
                setDescription(skill.description);
            })
            .catch(err => {
                console.error("Błąd ładowania umiejętności: ",err);
            });
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();

        const editedSkill = {
            name,
            relatedAttribute,
            description,
        };

        editSkill(id, editedSkill)
            .then(() => {
                alert('Edytowano umiejętność!');
                navigate('/skills');
            })
            .catch((err) => {
                setErrors(err);
                console.error('Nie udało się edytować umiejętności: ', err);
            });
    };

    return (
        <>
            <div className="container mb-3 p-1 my-1 bg-light rounded shadow-sm">
                <Link to="/">Strona główna </Link>
                <span>-></span>
                <Link to="/skills"> Umiejętności</Link>
            </div>
            <Container className="container p-1 my-1 bg-light rounded shadow-sm">
                <h2>Edytuj umiejętność</h2>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3">
                        <Form.Label>Nazwa:</Form.Label>
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
                        <Form.Label>Cecha bazowa:</Form.Label>
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
                        <Form.Label>Opis:</Form.Label>
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
                    <Button type="submit">Zapisz zmiany</Button>
                </Form>
            </Container>
        </>
    );
}

export default EditSkill;