export interface Attribute {
    key: string;
    value: number;
}

export interface Skill {
    id: string;
    name: string;
    relatedAttribute: string;
    advances: number;
}

export interface Talent {
    id: string;
    name: string;
}

export interface UnitTemplateDto {
    id: string;
    name: string;
    attributes: Attribute[];
    skills: Skill[];
    talents: Talent[];
}

export const emptyUnitTemplate: UnitTemplateDto = {
    id: "",
    name: "",
    attributes: [],
    skills: [],
    talents: []
};