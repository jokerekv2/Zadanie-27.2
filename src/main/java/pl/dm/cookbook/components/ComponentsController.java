package pl.dm.cookbook.components;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dm.cookbook.recipe.Recipe;
import pl.dm.cookbook.recipe.RecipeRepository;
import pl.dm.cookbook.recipe.RecipeService;

@Controller
public class ComponentsController {

    private final ComponentsService componentsService;
    private final RecipeService recipeService;

    public ComponentsController(ComponentsService componentsService, RecipeRepository recipeRepository, RecipeService recipeService) {
        this.componentsService = componentsService;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/component/add")
    public String addComponentToRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.findById(id));
        model.addAttribute("components", new Components());
        return "addComponent";
    }

    @PostMapping("/recipe/{id}/component/add")
    public String addComponentToRecipe(@PathVariable Long id, @RequestBody Components components, Model model) {
        componentsService.addComponent(components);
        Components added = componentsService.findFirstByOrderByIdDesc();
        Recipe recipe = recipeService.findById(id);
        return "";
    }

}
