import {apiFetch} from "./api";

export function getSkills() {
    return apiFetch('/api/skills');
}

export function deleteSkill(id) {
    return apiFetch(`/api/skills/${id}`, {
        method: 'DELETE',
    });
}

export function createSkill(data) {
    return apiFetch('/api/skills', {
        method: 'POST',
        body: JSON.stringify(data),
    });
}