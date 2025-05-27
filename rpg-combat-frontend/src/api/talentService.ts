import {apiFetch} from "./api";
import {TalentTemplate} from "../model/talentTemplate";

export function getTalents() : Promise<TalentTemplate[]>{
    return apiFetch<TalentTemplate[]>('/api/talents');
}