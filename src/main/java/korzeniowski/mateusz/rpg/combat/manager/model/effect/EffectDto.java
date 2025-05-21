package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EffectDto {
    private String id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @NotBlank
    @Size(min = 1, max = 1500)
    private String description;
    private List<@NotBlank @Size(min = 1, max = 50) String> affectedAttributes;
    private List<@NotBlank @Size(min = 1, max = 50) String> affectedSkills;
}
