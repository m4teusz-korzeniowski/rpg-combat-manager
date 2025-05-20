package korzeniowski.mateusz.rpg.combat.manager.model.talent;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "talent")
@Data
public class Talent {
    @Id
    private String id;
    private String name;
    private String description;

    private List<String> relatedSkills;
}
