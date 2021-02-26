package pl.dm.cookbook.category;

import lombok.Data;
import pl.dm.cookbook.recipe.Recipe;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipe;

}
