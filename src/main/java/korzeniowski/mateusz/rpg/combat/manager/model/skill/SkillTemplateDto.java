package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillTemplateDto {

    private String id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @NotBlank
    @Size(min = 1, max = 2000)
    private String description;
    @NotBlank
    @Size(min = 1, max = 50)
    private String relatedAttribute;
}
