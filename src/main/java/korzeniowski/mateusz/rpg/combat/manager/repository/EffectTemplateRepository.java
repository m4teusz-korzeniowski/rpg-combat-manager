package korzeniowski.mateusz.rpg.combat.manager.repository;

import korzeniowski.mateusz.rpg.combat.manager.model.effect.EffectTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EffectTemplateRepository extends MongoRepository<EffectTemplate, String> {
}
