package guru.springframework.controllers;

import guru.springframework.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipes"})
    public String getRecipes(Model model){
        log.debug("/recipes is called");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipe/index";
    }
}
