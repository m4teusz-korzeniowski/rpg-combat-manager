package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillTemplateDto {

    @NotNull
    private String name;
    @NotNull
    @Size(max = 1000)
    private String description;
    @NotNull
    private String relatedAttribute;
}
