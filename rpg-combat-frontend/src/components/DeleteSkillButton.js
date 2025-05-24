import {deleteSkill} from "../api/skillService";
import Button from "react-bootstrap/Button";

export function DeleteSkillButton({skillId, onDeleted}) {
    const handleDelete = async () => {
        if (window.confirm('Czy na pewno chcesz usunąć umiejętność?')) {
            try {
                await deleteSkill(skillId);
                onDeleted(skillId);
            } catch (err) {
                alert(err.message);
            }
        }
    };

    return(
        <Button variant="danger" onClick={handleDelete}>Usuń</Button>
    )
}