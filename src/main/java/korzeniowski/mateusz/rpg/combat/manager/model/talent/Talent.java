package korzeniowski.mateusz.rpg.combat.manager.model.talent;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Talent {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
}
