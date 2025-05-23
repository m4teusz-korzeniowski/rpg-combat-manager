package korzeniowski.mateusz.rpg.combat.manager.model.talent;

import org.springframework.stereotype.Service;

@Service
public class TalentMapper {

    public TalentDto map(Talent talent) {
        return new TalentDto(
                talent.getId(),
                talent.getName(),
                talent.getDescription(),
                talent.getRelatedSkillIds()
        );
    }

    public Talent map(TalentDto dto) {
        Talent talent = new Talent();
        talent.setId(dto.getId());
        talent.setName(dto.getName());
        talent.setDescription(dto.getDescription());
        talent.setRelatedSkillIds(dto.getRelatedSkillIds());
        return talent;
    }
}
