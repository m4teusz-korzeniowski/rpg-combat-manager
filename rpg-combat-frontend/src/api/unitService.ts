import {apiFetch} from "./api";
import {UnitTemplateDto} from "../model/unitTemplate";

export function getUnits(): Promise<UnitTemplateDto[]>{
    return apiFetch<UnitTemplateDto[]>('/api/units');
}