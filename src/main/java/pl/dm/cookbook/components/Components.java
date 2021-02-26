package pl.dm.cookbook.components;

import lombok.Data;
import pl.dm.cookbook.recipe.Recipe;

import javax.persistence.*;

@Entity
@Data
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grammage;

    @ManyToOne()
    private Recipe recipe;


}
