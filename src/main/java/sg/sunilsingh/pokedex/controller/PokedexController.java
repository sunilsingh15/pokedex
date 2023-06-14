package sg.sunilsingh.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.sunilsingh.pokedex.model.Pokemon;
import sg.sunilsingh.pokedex.service.PokedexService;

@Controller
@RequestMapping
public class PokedexController {

    @Autowired
    PokedexService service;
    
    @GetMapping
    public String index(Model model){ 

        List<Pokemon> pokeData = service.getPokemonData();
        model.addAttribute("pokeData", pokeData);

        return "index";
    }
}
