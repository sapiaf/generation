package org.learning.java.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.learning.java.springlamiapizzeriacrud.model.Pizza;
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

    @GetMapping("/")
    public String index(@RequestParam(name = "keyword") Optional<String> searchKeyword, Model model) {
        // Preparo la List di pizze da passare come attributo
        List<Pizza> pizzaList;
        // Preparo la variabile con il valore con cui precaricare l'input di ricerca
        String keyword = "";
        // Verifico se ho la stringa di ricerca
        if (searchKeyword.isPresent()) {
            keyword = searchKeyword.get();
            // Devo usare il metodo del repository che fa la ricerca filtrata
            pizzaList = pizzaRepository.findByNomeContainingIgnoreCase(keyword);
        } else {
            // Recupero tutte le pizze da database
            pizzaList = pizzaRepository.findAll();
        }
        // Passo la lista di pizze alla view tramite model attribute
        model.addAttribute("pizze", pizzaList);
        // Passo anche l'attributo keyword con la chiave di ricerca
        model.addAttribute("keyword", keyword);
        // Ritorno il nome del template
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
        return "form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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
            return "edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con id " + id + " non trovata");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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
