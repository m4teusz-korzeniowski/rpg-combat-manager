package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.AttributeKey;
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
    @Size(max = 2000)
    private String description;
    private List<@NotNull AttributeKey> affectedAttributes;
}
