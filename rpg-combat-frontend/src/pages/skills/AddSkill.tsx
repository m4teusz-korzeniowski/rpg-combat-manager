import React, { useState, FormEvent, ChangeEvent } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Form, Button, Container } from 'react-bootstrap';
import {AttributeKey, attributeMap} from '../../utils/attributeMapper';
import { createSkill } from '../../api/skillService';

interface Skill {
    name: string;
    relatedAttribute: string;
    description: string;
}

interface SkillErrors {
    name?: string;
    relatedAttribute?: string;
    description?: string;
    [key: string]: string | undefined;
}

const AddSkill: React.FC = () => {
    const [name, setName] = useState<string>('');
    const attributeKeys = Object.keys(attributeMap).filter((key) => !['W', 'M'].includes(key));
    const [relatedAttribute, setRelatedAttribute] = useState<string>(attributeKeys[0] || '');
    const [description, setDescription] = useState<string>('');
    const [errors, setErrors] = useState<SkillErrors>({});
    const navigate = useNavigate();

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        const newSkill: Skill = {
            name,
            relatedAttribute,
            description,
        };

        createSkill(newSkill)
            .then(() => {
                alert('Dodano nową umiejętność!');
                navigate('/skills');
            })
            .catch((err: SkillErrors) => {
                setErrors(err);
                console.error('Nie udało się dodać umiejętności: ', err);
            });
    };

    return (
        <>
            <div className="container mb-3 p-1 my-1 bg-light rounded shadow-sm">
                <Link to="/">Strona główna </Link>
                <span>→</span>
                <Link to="/skills"> Umiejętności</Link>
            </div>

            <Container className="container p-1 my-1 bg-light rounded shadow-sm">
                <h2>Dodaj nową umiejętność</h2>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3">
                        <Form.Label>Nazwa:</Form.Label>
                        <Form.Control
                            type="text"
                            value={name}
                            onChange={(e: ChangeEvent<HTMLInputElement>) => setName(e.target.value)}
                            isInvalid={!!errors.name}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.name}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Cecha bazowa:</Form.Label>
                        <Form.Select
                            value={relatedAttribute}
                            onChange={(e: ChangeEvent<HTMLSelectElement>) => setRelatedAttribute(e.target.value)}
                            isInvalid={!!errors.relatedAttribute}
                        >
                            {attributeKeys.map((key) => (
                                <option key={key} value={key}>
                                    {attributeMap[key as AttributeKey].label}
                                </option>
                            ))}
                        </Form.Select>
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Opis:</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={8}
                            value={description}
                            onChange={(e: ChangeEvent<HTMLTextAreaElement>) => setDescription(e.target.value)}
                            isInvalid={!!errors.description}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.description}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Button type="submit">Dodaj</Button>
                </Form>
            </Container>
        </>
    );
};

export default AddSkill;
