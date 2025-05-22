package korzeniowski.mateusz.rpg.combat.manager.controller;

import jakarta.validation.Valid;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplateDto;
import korzeniowski.mateusz.rpg.combat.manager.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<SkillTemplateDto>> getSkills() {
        List<SkillTemplateDto> skills = skillService.getSkillTemplates();
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillTemplateDto> getSkillById(@PathVariable(value = "id") String id) {
        SkillTemplateDto skill = skillService.getSkillTemplateById(id);
        return ResponseEntity.ok(skill);
    }

    @PostMapping
    public ResponseEntity<SkillTemplateDto> createSkill(@RequestBody @Valid SkillTemplateDto skill) {
        SkillTemplateDto created = skillService.createSkillTemplate(skill);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkillById(@PathVariable(value = "id") String id) {
        skillService.deleteSkillTemplate(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillTemplateDto> updateSkill(@PathVariable(value = "id") String id,
                                                        @RequestBody @Valid SkillTemplateDto skill) {
        SkillTemplateDto updated = skillService.updateSkillTemplate(skill, id);
        return ResponseEntity.ok(updated);
    }


}
