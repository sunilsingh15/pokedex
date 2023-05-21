package sg.sunilsingh.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.sunilsingh.pokedex.service.PokemonService;

@Controller
@RequestMapping
public class PokedexController {

    @Autowired
    PokemonService service;
    
    @GetMapping
    public String index(Model model){ 

        List<String> pokeList = service.getPokemonNames();
        model.addAttribute("pokeList", pokeList);

        return "index";
    }
}
