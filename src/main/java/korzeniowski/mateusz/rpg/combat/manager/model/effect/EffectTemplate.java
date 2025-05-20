package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "effect")
@Data
public class EffectTemplate {
    @Id
    private String id;
    private String name;
    private String description;

    private List<String> affectedAttributes;
    private List<String> affectedSkills;
}
