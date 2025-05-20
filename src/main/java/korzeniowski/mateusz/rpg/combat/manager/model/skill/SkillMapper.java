package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import org.springframework.stereotype.Service;

@Service
public class SkillMapper {

    public SkillTemplateDto map(SkillTemplate skill) {
        return new SkillTemplateDto(
                skill.getName(),
                skill.getDescription(),
                skill.getRelatedAttribute());
    }

    public SkillTemplate map(SkillTemplateDto dto) {
        SkillTemplate skill = new SkillTemplate();
        skill.setName(dto.getName());
        skill.setDescription(dto.getDescription());
        skill.setRelatedAttribute(dto.getRelatedAttribute());
        return skill;
    }

}
