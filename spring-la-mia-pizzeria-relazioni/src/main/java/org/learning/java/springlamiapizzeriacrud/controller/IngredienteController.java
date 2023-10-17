package org.learning.java.springlamiapizzeriacrud.controller;

import org.learning.java.springlamiapizzeriacrud.model.Ingrediente;
import org.learning.java.springlamiapizzeriacrud.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping
    public String listIngredienti(Model model) {
        model.addAttribute("ingredienti", ingredienteRepository.findAll());
        return "ingredienti-list";
    }
    @GetMapping("/new")
    public String newIngrediente(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "ingredienti-form";
    }

    @PostMapping
    public String addIngrediente(@ModelAttribute Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
        return "redirect:/ingredienti";
    }

    @PostMapping("/delete/{id}")
    public String deleteIngrediente(@PathVariable Integer id) {
        ingredienteRepository.deleteById(id);
        return "redirect:/ingredienti";
    }

}
