package korzeniowski.mateusz.rpg.combat.manager.repository;


import korzeniowski.mateusz.rpg.combat.manager.model.unit.UnitTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitRepository extends MongoRepository<UnitTemplate, String> {

}
