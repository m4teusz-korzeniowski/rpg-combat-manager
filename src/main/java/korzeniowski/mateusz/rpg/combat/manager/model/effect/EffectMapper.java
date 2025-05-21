package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import org.springframework.stereotype.Service;

@Service
public class EffectMapper {

    public EffectDto map(EffectTemplate effect) {
        return new EffectDto(
                effect.getId(),
                effect.getName(),
                effect.getDescription(),
                effect.getAffectedAttributes(),
                effect.getAffectedSkills());
    }

    public EffectTemplate map(EffectDto dto) {
        EffectTemplate effect = new EffectTemplate();
        effect.setId(dto.getId());
        effect.setName(dto.getName());
        effect.setDescription(dto.getDescription());
        effect.setAffectedAttributes(dto.getAffectedAttributes());
        effect.setAffectedSkills(dto.getAffectedSkills());
        return effect;
    }
}
