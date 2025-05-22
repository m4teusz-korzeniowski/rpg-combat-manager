package korzeniowski.mateusz.rpg.combat.manager.model.unit;

import korzeniowski.mateusz.rpg.combat.manager.model.effect.StatusEffect;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Unit {

    private String name;
    private String unitTemplateId;
    private Integer currentWounds;
    private List<StatusEffect> effects;
}
