package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skill")
@Data
public class SkillTemplate {
    @Id
    private String id;
    private String name;
    private String description;

    private String relatedAttribute;
}
