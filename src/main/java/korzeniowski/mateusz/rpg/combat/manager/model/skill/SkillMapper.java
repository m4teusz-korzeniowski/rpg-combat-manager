package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import korzeniowski.mateusz.rpg.combat.manager.model.unit.AttributeKey;
import org.springframework.stereotype.Service;

@Service
public class SkillMapper {

    public SkillTemplateDto map(SkillTemplate skill) {
        return new SkillTemplateDto(
                skill.getId(),
                skill.getName(),
                skill.getDescription(),
                AttributeKey.valueOf(skill.getRelatedAttribute()));
    }

    public SkillTemplate map(SkillTemplateDto dto) {
        SkillTemplate skill = new SkillTemplate();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setDescription(dto.getDescription());
        skill.setRelatedAttribute(dto.getRelatedAttribute().name());
        return skill;
    }

}
