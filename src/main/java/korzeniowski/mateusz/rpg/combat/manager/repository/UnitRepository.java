package korzeniowski.mateusz.rpg.combat.manager.repository;


import korzeniowski.mateusz.rpg.combat.manager.model.character.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitRepository extends MongoRepository<Unit, String> {

}
