package korzeniowski.mateusz.rpg.combat.manager.service;

import korzeniowski.mateusz.rpg.combat.manager.exception.ResourceNotFoundException;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.UnitMapper;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.UnitTemplate;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.UnitTemplateDto;
import korzeniowski.mateusz.rpg.combat.manager.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    public UnitService(UnitRepository unitRepository, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.unitMapper = unitMapper;
    }

    public List<UnitTemplateDto> getUnits() {
        return unitRepository.findAll()
                .stream().map(unitMapper::map)
                .toList();
    }

    public UnitTemplateDto getUnitTemplateById(String id) {
        return unitRepository.findById(id)
                .map(unitMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Unit with id: " + id + " not found!"));
    }

    public UnitTemplateDto createUnitTemplate(UnitTemplateDto dto) {
        UnitTemplate unit = unitMapper.map(dto);
        UnitTemplate saved = unitRepository.save(unit);
        return unitMapper.map(saved);
    }

    public UnitTemplateDto updateUnitTemplate(UnitTemplateDto dto, String id) {
        UnitTemplate unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit with id: " + id + " not found!"));
        unit.setName(dto.getName());
        unit.setSkills(dto.getSkills());
        unit.setAttributes(dto.getAttributes());
        unit.setTalents(dto.getTalents());
        UnitTemplate updated = unitRepository.save(unit);
        return unitMapper.map(updated);
    }

    public void deleteUnitTemplate(String id) {
        UnitTemplate unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit with id: " + id + " not found!"));
        unitRepository.delete(unit);
    }
}
