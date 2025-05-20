package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillTemplateDto {
    private String name;
    private String description;
    private String relatedAttribute;
}
