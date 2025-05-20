package korzeniowski.mateusz.rpg.combat.manager.controller;

import jakarta.validation.Valid;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.TalentDto;
import korzeniowski.mateusz.rpg.combat.manager.service.TalentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talents")
@CrossOrigin
public class TalentController {

    private final TalentService talentService;

    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping
    public ResponseEntity<List<TalentDto>> getTalents() {
        List<TalentDto> talents = talentService.getTalents();
        return ResponseEntity.ok(talents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TalentDto> getTalentById(@PathVariable("id") String id) {
        TalentDto talentDto = talentService.getTalentById(id);
        return ResponseEntity.ok(talentDto);
    }

    @PostMapping
    public ResponseEntity<TalentDto> createTalent(@RequestBody @Valid TalentDto talent) {
        TalentDto created = talentService.createTalent(talent);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TalentDto> updateTalent(@PathVariable("id") String id,
                                                  @RequestBody @Valid TalentDto talent) {
        TalentDto updated = talentService.updateTalent(talent, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTalent(@PathVariable("id") String id) {
        talentService.deleteTalent(id);
        return ResponseEntity.noContent().build();
    }
}
