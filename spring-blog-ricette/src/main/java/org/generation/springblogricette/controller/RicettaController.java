package org.generation.springblogricette.controller;

import jakarta.validation.Valid;
import org.generation.springblogricette.model.Ricetta;
import org.generation.springblogricette.repository.CategoriaRepository;
import org.generation.springblogricette.repository.RicettaRepository;
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
@RequestMapping("/ricette")
public class RicettaController {
    @Autowired
    private RicettaRepository ricettaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping
    public String index(Model model) {
        List<Ricetta> ricette = ricettaRepository.findAll();
        model.addAttribute("ricette", ricette);
        return "ricette/index";
    }
    @GetMapping("/{id}")
    public String visualizzaRicetta(@PathVariable Integer id, Model model) {
        Optional<Ricetta> ricetta = ricettaRepository.findById(id);
        if (ricetta.isPresent()) {
            model.addAttribute("ricetta", ricetta.get());
            return "/ricette/ricetta";
        } else {
            return "redirect:/ricette";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ricette", new Ricetta());
        model.addAttribute("categorie", categoriaRepository.findAll());
        return "/ricette/form";
    }
    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("ricette") Ricetta formRicetta, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorie", categoriaRepository.findAll());
            return "/ricette/form";
        }
        ricettaRepository.save(formRicetta);
        return "redirect:/ricette";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Ricetta> result = ricettaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("ricette", result.get());
            model.addAttribute("categorie", categoriaRepository.findAll());
            return "/ricette/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta con id " + id + " non trovata");
        }
    }
    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("ricette") Ricetta formRicetta, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorie", categoriaRepository.findAll());
            return "/ricette/edit";
        }
        ricettaRepository.save(formRicetta);
        return "redirect:/ricette";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        ricettaRepository.deleteById(id);
        return "redirect:/ricette";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q") String searchString, Model model) {
        System.out.println("searchString:" + searchString);
        List<Ricetta> filteredRicetteList = ricettaRepository.findByTitoloContainingIgnoreCase(searchString);
        model.addAttribute("ricette", filteredRicetteList);
        return "ricette/index";
    }


}
