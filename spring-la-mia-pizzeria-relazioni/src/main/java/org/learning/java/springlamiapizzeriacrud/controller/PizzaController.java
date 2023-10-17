package org.learning.java.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.learning.java.springlamiapizzeriacrud.model.Offerta;
import org.learning.java.springlamiapizzeriacrud.model.Pizza;
import org.learning.java.springlamiapizzeriacrud.repository.IngredienteRepository;
import org.learning.java.springlamiapizzeriacrud.repository.OffertaRepository;
import org.learning.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private OffertaRepository offertaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping("/")
    public String index(@RequestParam(name = "keyword") Optional<String> searchKeyword, Model model) {
        List<Pizza> pizzaList;
        String keyword = "";
        if (searchKeyword.isPresent()) {
            keyword = searchKeyword.get();
            pizzaList = pizzaRepository.findByNomeContainingIgnoreCase(keyword);
        } else {
            pizzaList = pizzaRepository.findAll();
        }
        model.addAttribute("pizze", pizzaList);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/pizza/{id}")
    public String showDettagliPizza(@PathVariable Integer id, Model model) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(id);
        if (optionalPizza.isPresent()) {
            Pizza pizzaFromDB = optionalPizza.get();
            model.addAttribute("pizza", pizzaFromDB);
            return "pizza";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("ingredienti", ingredienteRepository.findAll());
        return "form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("ingredienti", ingredienteRepository.findAll());
            return "form";
        }
        pizzaRepository.save(formPizza);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("pizza", result.get());
            model.addAttribute("ingredienti", ingredienteRepository.findAll());
            return "edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con id " + id + " non trovata");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("ingredienti", ingredienteRepository.findAll());
            return "edit";
        }
        pizzaRepository.save(formPizza);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        pizzaRepository.deleteById(id);
        return "redirect:/";
    }
}
