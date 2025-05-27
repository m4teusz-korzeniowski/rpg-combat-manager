package korzeniowski.mateusz.rpg.combat.manager.model.talent;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "talent")
@Data
public class TalentTemplate {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    private List<String> relatedSkillIds;
}
