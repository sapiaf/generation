package org.learning.java.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.learning.java.springlamiapizzeriacrud.model.Offerta;
import org.learning.java.springlamiapizzeriacrud.model.Pizza;
import org.learning.java.springlamiapizzeriacrud.repository.OffertaRepository;
import org.learning.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
    @Autowired
    private OffertaRepository offertaRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/create")
    public String create(@RequestParam("pizzaId") Integer pizzaId, Model model) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(pizzaId);
        if (optionalPizza.isPresent()) {
            Offerta offerta = new Offerta();
            offerta.setPizza(optionalPizza.get());
            model.addAttribute("offerta", offerta);
            return "offertaForm";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con id " + pizzaId + " non trovata");
        }
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("offerta") Offerta offerta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "offertaForm";
        }
        offertaRepository.save(offerta);
        return "redirect:/pizza/" + offerta.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Offerta> optionalOfferta = offertaRepository.findById(id);
        if (optionalOfferta.isPresent()) {
            model.addAttribute("offerta", optionalOfferta.get());
            return "offertaEdit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offerta con id " + id + " non trovata");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable("id") Integer id, @Valid @ModelAttribute("offerta") Offerta offerta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "offertaEdit";
        }
        offerta.setId(id);
        offertaRepository.save(offerta);
        return "redirect:/pizza/" + offerta.getPizza().getId();
    }
}
