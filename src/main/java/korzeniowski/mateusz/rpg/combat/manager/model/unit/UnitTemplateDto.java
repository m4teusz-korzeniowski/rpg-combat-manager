package korzeniowski.mateusz.rpg.combat.manager.model.unit;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.Skill;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.Talent;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.TalentTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UnitTemplateDto {
    private String id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @Size(min = 9)
    private List<@Valid Attribute> attributes;
    private List<@Valid Skill> skills;
    private List<@Valid Talent> talents;
}
