package pl.dm.cookbook.recipe;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void addLike(Long id) {
        recipeRepository.addLike(id);
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            return recipeOptional.get();
        } else {
            throw new NoSuchElementException("No such element");
        }
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> sortByLikes() {
        return recipeRepository.findAllByOrderByLikesDesc();
    }

    public List<Recipe> findByCategory(Long id) {
        return recipeRepository.findAllByCategory_Id(id);
    }

    public void save(Recipe newRecipe) {
        recipeRepository.save(newRecipe);
    }
}
