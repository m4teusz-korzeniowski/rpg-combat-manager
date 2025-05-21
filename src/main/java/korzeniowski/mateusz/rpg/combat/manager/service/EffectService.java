package korzeniowski.mateusz.rpg.combat.manager.service;

import korzeniowski.mateusz.rpg.combat.manager.exception.ResourceNotFoundException;
import korzeniowski.mateusz.rpg.combat.manager.model.effect.EffectDto;
import korzeniowski.mateusz.rpg.combat.manager.model.effect.EffectMapper;
import korzeniowski.mateusz.rpg.combat.manager.model.effect.EffectTemplate;
import korzeniowski.mateusz.rpg.combat.manager.repository.EffectTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EffectService {

    private final EffectTemplateRepository effectTemplateRepository;
    private final EffectMapper effectMapper;

    public EffectService(EffectTemplateRepository effectTemplateRepository, EffectMapper effectMapper) {
        this.effectTemplateRepository = effectTemplateRepository;
        this.effectMapper = effectMapper;
    }

    public List<EffectDto> getEffects() {
        return effectTemplateRepository.findAll()
                .stream().map(effectMapper::map)
                .toList();
    }

    public EffectDto getEffect(String id) {
        return effectTemplateRepository.findById(id)
                .map(effectMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Effect with id " + id + " not found"));
    }

    public EffectDto createEffect(EffectDto dto) {
        EffectTemplate effect = effectMapper.map(dto);
        EffectTemplate saved = effectTemplateRepository.save(effect);
        return effectMapper.map(saved);
    }

    public EffectDto updateEffect(String id, EffectDto dto) {
        EffectTemplate effect = effectTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Effect with id " + id + " not found"));
        effect.setName(dto.getName());
        effect.setDescription(dto.getDescription());
        effect.setAffectedSkills(dto.getAffectedSkills());
        effect.setAffectedAttributes(dto.getAffectedAttributes());
        return effectMapper.map(effect);
    }

    public void deleteEffect(String id) {
        EffectTemplate effect = effectTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Effect with id " + id + " not found"));
        effectTemplateRepository.delete(effect);
    }
}
