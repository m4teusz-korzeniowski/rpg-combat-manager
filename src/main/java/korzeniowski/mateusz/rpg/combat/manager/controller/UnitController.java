package korzeniowski.mateusz.rpg.combat.manager.controller;

import korzeniowski.mateusz.rpg.combat.manager.model.character.Unit;
import korzeniowski.mateusz.rpg.combat.manager.repository.UnitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin
public class UnitController {

    private final UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> getAllCharacters() {
        return unitRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Unit> createCharacter(@RequestBody Unit unit) {
        Unit saved = unitRepository.save(unit);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
