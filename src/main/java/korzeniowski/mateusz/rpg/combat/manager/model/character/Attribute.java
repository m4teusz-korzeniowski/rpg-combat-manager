package korzeniowski.mateusz.rpg.combat.manager.model.character;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attribute {

    @NotNull
    private AttributeKey key;
    @Min(0)
    private Integer value;
}
