package pl.dm.cookbook.recipe;

import lombok.Data;
import pl.dm.cookbook.components.Components;
import pl.dm.cookbook.category.Category;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "recipe")
    private List<Components> components;

    @Column(length = 1000)
    private String preparation;
    private int likes = 0;
    private String imgUrl;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

}
