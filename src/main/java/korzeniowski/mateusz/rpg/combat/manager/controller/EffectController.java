package korzeniowski.mateusz.rpg.combat.manager.controller;

import jakarta.validation.Valid;
import korzeniowski.mateusz.rpg.combat.manager.model.effect.EffectDto;
import korzeniowski.mateusz.rpg.combat.manager.service.EffectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/effects")
@CrossOrigin
public class EffectController {

    private final EffectService effectService;

    public EffectController(EffectService effectService) {
        this.effectService = effectService;
    }

    @GetMapping
    public ResponseEntity<List<EffectDto>> getEffects() {
        List<EffectDto> effects = effectService.getEffects();
        return ResponseEntity.ok(effects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EffectDto> getEffectById(@PathVariable("id") String id) {
        EffectDto effect = effectService.getEffect(id);
        return ResponseEntity.ok(effect);
    }

    @PostMapping
    public ResponseEntity<EffectDto> createEffect(@RequestBody @Valid EffectDto effect) {
        EffectDto created = effectService.createEffect(effect);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EffectDto> updateEffect(@PathVariable("id") String id,
                                                  @RequestBody @Valid EffectDto effect) {
        EffectDto updated = effectService.updateEffect(id, effect);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEffect(@PathVariable("id") String id) {
        effectService.deleteEffect(id);
        return ResponseEntity.noContent().build();
    }
}
