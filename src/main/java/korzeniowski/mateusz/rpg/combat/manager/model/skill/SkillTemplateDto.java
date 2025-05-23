package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.AttributeKey;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillTemplateDto {

    private String id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @Size(max = 2000)
    private String description;
    @NotNull
    private AttributeKey relatedAttribute;
}
