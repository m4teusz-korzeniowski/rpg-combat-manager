package korzeniowski.mateusz.rpg.combat.manager.model.unit;

import org.springframework.stereotype.Service;

@Service
public class UnitMapper {

    public UnitTemplateDto map(UnitTemplate unit) {
        return new UnitTemplateDto(
                unit.getId(),
                unit.getName(),
                unit.getAttributes(),
                unit.getSkills(),
                unit.getTalentIds());
    }

    public UnitTemplate map(UnitTemplateDto dto) {
        UnitTemplate unit = new UnitTemplate();
        unit.setId(dto.getId());
        unit.setName(dto.getName());
        unit.setAttributes(dto.getAttributes());
        unit.setSkills(dto.getSkills());
        unit.setTalentIds(dto.getTalentIds());
        return unit;
    }
}
