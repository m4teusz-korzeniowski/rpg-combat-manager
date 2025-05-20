package korzeniowski.mateusz.rpg.combat.manager.model.character;

import korzeniowski.mateusz.rpg.combat.manager.model.effect.StatusEffect;
import korzeniowski.mateusz.rpg.combat.manager.model.skill.Skill;
import korzeniowski.mateusz.rpg.combat.manager.model.talent.Talent;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "characters")
@Data
public class Unit {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<Attribute> attributes;
    private List<Skill> skills;
    private List<Talent> talents;
    private List<StatusEffect> effects;
}
