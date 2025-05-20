package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import lombok.Data;

@Data
public class StatusEffect {
    private String effectTemplateId;
    private Integer duration;
}
