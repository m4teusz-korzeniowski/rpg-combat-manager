package korzeniowski.mateusz.rpg.combat.manager.repository;

import korzeniowski.mateusz.rpg.combat.manager.model.talent.Talent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalentRepository extends MongoRepository<Talent, String> {

}
