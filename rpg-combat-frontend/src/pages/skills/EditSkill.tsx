import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Form, Button, Container } from "react-bootstrap";
import { attributeMap, AttributeKey } from "../../utils/attributeMapper";
import { editSkill, getSkill } from "../../api/skillService";
import React from "react";
import {SkillTemplate} from "../../model/skillTemplate";

interface Skill {
    name: string;
    relatedAttribute: AttributeKey;
    description: string;
}

type ErrorMessages = {
    name?: string;
    relatedAttribute?: string;
    description?: string;
};

function EditSkill() {
    const { id } = useParams<{ id: string }>();
    const [name, setName] = useState<string>('');
    const [relatedAttribute, setRelatedAttribute] = useState<AttributeKey>('S');
    const [description, setDescription] = useState<string>('');
    const [errors, setErrors] = useState<ErrorMessages>({});
    const navigate = useNavigate();

    useEffect(() => {
        if (!id) return;

        getSkill(id)
            .then((skill: SkillTemplate) => {
                setName(skill.name);
                setRelatedAttribute(skill.relatedAttribute as AttributeKey);
                setDescription(skill.description);
            })
            .catch(err => {
                console.error("Błąd ładowania umiejętności: ", err);
            });
    }, [id]);

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        const editedSkill: Skill = {
            name,
            relatedAttribute,
            description,
        };

        if (!id) return;

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

    const attributeKeys = Object.keys(attributeMap).filter(
        (key): key is AttributeKey => !['W', 'M'].includes(key)
);

    return (
        <>
            <div className="container mb-3 p-1 my-1 bg-light rounded shadow-sm">
                <Link to="/">Strona główna</Link>
                <span> → </span>
                <Link to="/skills">Umiejętności</Link>
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
                            onChange={(e) => setRelatedAttribute(e.target.value as AttributeKey)}
                            isInvalid={!!errors.relatedAttribute}
                        >
                            {attributeKeys.map((key) => (
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
