package korzeniowski.mateusz.rpg.combat.manager.service;

import korzeniowski.mateusz.rpg.combat.manager.exception.ResourceNotFoundException;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillMapper;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplate;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplateDto;
import korzeniowski.mateusz.rpg.combat.manager.repository.SkillTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillTemplateRepository skillTemplateRepository;
    private final SkillMapper skillMapper;

    public SkillService(SkillTemplateRepository skillTemplateRepository, SkillMapper skillMapper) {
        this.skillTemplateRepository = skillTemplateRepository;
        this.skillMapper = skillMapper;
    }

    public List<SkillTemplateDto> getSkillTemplates() {
        return skillTemplateRepository.findAll()
                .stream()
                .map(skillMapper::map)
                .toList();
    }

    public SkillTemplateDto getSkillTemplateByName(String name) {
        return skillTemplateRepository.findByName(name)
                .map(skillMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Skill with name: " + name + " not found!"));
    }

    public SkillTemplateDto getSkillTemplateById(String id) {
        return skillTemplateRepository.findById(id)
                .map(skillMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Skill with id: " + id + " not found!"));
    }

    public SkillTemplateDto createSkillTemplate(SkillTemplateDto dto) {
        SkillTemplate skill = skillMapper.map(dto);
        SkillTemplate saved = skillTemplateRepository.save(skill);
        return skillMapper.map(saved);
    }

    public SkillTemplateDto updateSkillTemplate(SkillTemplateDto dto, String id) {
        SkillTemplate skill = skillTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill with id: " + id + " not found!"));
        skill.setName(dto.getName());
        skill.setDescription(dto.getDescription());
        skill.setRelatedAttribute(dto.getRelatedAttribute());
        SkillTemplate updated = skillTemplateRepository.save(skill);
        return skillMapper.map(updated);
    }

    public void deleteSkillTemplate(String id) {
        SkillTemplate skill = skillTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill with id: " + id + " not found!"));
        skillTemplateRepository.delete(skill);
    }
}
