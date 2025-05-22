package korzeniowski.mateusz.rpg.combat.manager.model.unit;

import korzeniowski.mateusz.rpg.combat.manager.model.skill.Skill;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "units")
@Data
public class UnitTemplate {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<Attribute> attributes;
    private List<Skill> skills;
    private List<String> talentIds;
}