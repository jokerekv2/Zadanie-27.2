package pl.dm.cookbook.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("UPDATE Recipe recipe SET recipe.likes = recipe.likes + 1 WHERE recipe.id = :id")
    @Modifying
    @Transactional
    void addLike(@Param("id") Long id);

    List<Recipe> findAllByOrderByLikesDesc();
    List<Recipe> findAllByCategory_Id(Long id);
}
