import {apiFetch} from "./api";
import {SkillTemplate} from "../model/skillTemplate"

export function getSkills(): Promise<SkillTemplate[]> {
    return apiFetch<SkillTemplate[]>('/api/skills');
}

export function getSkill(id: string): Promise<SkillTemplate> {
    return apiFetch<SkillTemplate>(`/api/skills/${id}`);
}

export function deleteSkill(id: string): Promise<void> {
    return apiFetch<void>(`/api/skills/${id}`, {
        method: 'DELETE',
    });
}

export function createSkill(data: Omit<SkillTemplate, 'id'>): Promise<SkillTemplate> {
    return apiFetch<SkillTemplate>('/api/skills', {
        method: 'POST',
        body: JSON.stringify(data),
    });
}

export function editSkill(id: string, data: Omit<SkillTemplate, 'id'>): Promise<SkillTemplate> {
    return apiFetch<SkillTemplate>(`/api/skills/${id}`, {
        method: 'PUT',
        body: JSON.stringify(data),
    })
}