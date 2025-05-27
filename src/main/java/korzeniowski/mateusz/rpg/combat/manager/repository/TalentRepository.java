package korzeniowski.mateusz.rpg.combat.manager.repository;

import korzeniowski.mateusz.rpg.combat.manager.model.talent.TalentTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalentRepository extends MongoRepository<TalentTemplate, String> {

}
