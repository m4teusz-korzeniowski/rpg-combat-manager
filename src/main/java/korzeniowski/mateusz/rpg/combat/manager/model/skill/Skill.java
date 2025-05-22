package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Skill {
    @NotBlank
    private String skillTemplateId;
    @Min(0)
    private Integer advances;
}
