package korzeniowski.mateusz.rpg.combat.manager.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skill")
@Data
public class SkillTemplate {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    private String relatedAttribute;
}
