package korzeniowski.mateusz.rpg.combat.manager.controller;

import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplate;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplateDto;
import korzeniowski.mateusz.rpg.combat.manager.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
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

    @GetMapping("/{name}")
    public ResponseEntity<SkillTemplateDto> getSkillByName(@PathVariable(value = "name") String name) {
        SkillTemplateDto skill = skillService.getSkillTemplateByName(name);
        return ResponseEntity.ok(skill);
    }

    @PostMapping
    public ResponseEntity<SkillTemplateDto> createSkill(@RequestBody SkillTemplateDto skill) {
        SkillTemplateDto created = skillService.createSkillTemplate(skill);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

}
