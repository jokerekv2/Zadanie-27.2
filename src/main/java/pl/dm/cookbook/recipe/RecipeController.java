package pl.dm.cookbook.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dm.cookbook.components.Components;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/recipe/{id}")
    private String showRecipe(@PathVariable Long id, Model model) {
        model.addAttribute(recipeService.findById(id));
        return "recipe";
    }

    @GetMapping("/recipe/{id}/add-like")
    public String addLike(@PathVariable Long id) {
        recipeService.addLike(id);
        return "redirect:/";
    }

    @GetMapping("/recipes/sort-by-likes")
    public String sortByLikes(Model model) {
        model.addAttribute("recipes", recipeService.sortByLikes());
        return "recipes";
    }

    @GetMapping("/recipes/sort-by-category/{id}")
    public String sortByCategory(@PathVariable Long id, Model model) {
        model.addAttribute("recipes", recipeService.findByCategory(id));
        return "recipes";
    }

    @GetMapping("/recipe/add")
    public String addRecipe(Model model) {
        Recipe newRecipe = new Recipe();
        model.addAttribute("recipe", newRecipe);
        model.addAttribute("mode", "add");
        return "addOrEditRecipe";
    }

    @PostMapping("/recipe/add")
    private String addRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}/delete")
    public String delete(@PathVariable Long id) {
        recipeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}/edit")
    public String editRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "addOrEditRecipe";
    }

    @PostMapping("/recipe/edit")
    public String editRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/recipe/" + recipe.getId();
    }




}
