package korzeniowski.mateusz.rpg.combat.manager.model.effect;

import korzeniowski.mateusz.rpg.combat.manager.model.unit.AttributeKey;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "effect")
@Data
public class EffectTemplate {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    private List<AttributeKey> affectedAttributes;
}
