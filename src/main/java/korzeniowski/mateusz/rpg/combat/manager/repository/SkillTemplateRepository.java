package korzeniowski.mateusz.rpg.combat.manager.repository;

import korzeniowski.mateusz.rpg.combat.manager.model.skill.SkillTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SkillTemplateRepository extends MongoRepository<SkillTemplate, String> {

    Optional<SkillTemplate> findByName(String name);
}
