import React from "react";
import {deleteSkill} from "../api/skillService";
import Button from "react-bootstrap/Button";

interface DeleteSkillButtonProps{
    skillId: string;
    onDeleted: (id: string) => void;
}

export function DeleteSkillButton({skillId, onDeleted}: DeleteSkillButtonProps) {
    const handleDelete = async () => {
        if (window.confirm('Czy na pewno chcesz usunąć umiejętność?')) {
            try {
                await deleteSkill(skillId);
                onDeleted(skillId);
            } catch (err) {
                if (err instanceof Error) {
                    alert(err.message);
                } else {
                    alert(String(err));
                }
            }
        }
    };

    return(
        <Button variant="danger" onClick={handleDelete}>Usuń</Button>
    )
}