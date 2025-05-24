package korzeniowski.mateusz.rpg.combat.manager.service;

import korzeniowski.mateusz.rpg.combat.manager.exception.ResourceNotFoundException;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.Talent;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.TalentDto;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.TalentMapper;
import korzeniowski.mateusz.rpg.combat.manager.repository.TalentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    private final TalentRepository talentRepository;
    private final TalentMapper talentMapper;

    public TalentService(TalentRepository talentRepository, TalentMapper talentMapper) {
        this.talentRepository = talentRepository;
        this.talentMapper = talentMapper;
    }

    public List<TalentDto> getTalents() {
        return talentRepository.findAll()
                .stream().map(talentMapper::map)
                .toList();
    }

    public TalentDto getTalentById(String id) {
        return talentRepository.findById(id)
                .map(talentMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Talent with id " + id + " not found"));
    }

    public TalentDto createTalent(TalentDto dto) {
        Talent talent = talentMapper.map(dto);
        Talent saved = talentRepository.save(talent);
        return talentMapper.map(saved);
    }

    public TalentDto updateTalent(TalentDto dto, String id) {
        Talent talent = talentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talent with id " + id + " not found"));
        talent.setName(dto.getName());
        talent.setDescription(dto.getDescription());
        Talent updated = talentRepository.save(talent);
        return talentMapper.map(updated);
    }

    public void deleteTalent(String id) {
        Talent talent = talentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talent with id " + id + " not found"));
        talentRepository.delete(talent);
    }
}
