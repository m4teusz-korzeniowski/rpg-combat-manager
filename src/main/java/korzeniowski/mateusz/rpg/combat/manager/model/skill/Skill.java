package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.AttributeKey;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Skill {
    @NotBlank
    private String skillTemplateId;
    @NotBlank
    private String name;
    @NotNull
    private AttributeKey relatedAttribute;
    @Min(0)
    private Integer advances;
}
