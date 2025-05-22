package korzeniowski.mateusz.rpg.combat.manager.controller;

import jakarta.validation.Valid;
import korzeniowski.mateusz.rpg.combat.manager.model.unit.UnitTemplateDto;
import korzeniowski.mateusz.rpg.combat.manager.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@CrossOrigin
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<UnitTemplateDto>> getUnits() {
        List<UnitTemplateDto> units = unitService.getUnits();
        return ResponseEntity.ok(units);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitTemplateDto> getUnitById(@PathVariable("id") String id) {
        UnitTemplateDto unit = unitService.getUnitTemplateById(id);
        return ResponseEntity.ok(unit);
    }

    @PostMapping
    public ResponseEntity<UnitTemplateDto> createUnit(@RequestBody @Valid UnitTemplateDto unit) {
        UnitTemplateDto created = unitService.createUnitTemplate(unit);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitTemplateDto> updateUnit(@PathVariable("id") String id,
                                                  @RequestBody @Valid UnitTemplateDto unit) {
        UnitTemplateDto updated = unitService.updateUnitTemplate(unit, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable("id") String id) {
        unitService.deleteUnitTemplate(id);
        return ResponseEntity.noContent().build();
    }

}
