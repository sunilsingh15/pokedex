package sg.sunilsingh.pokedex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PokedexController {
    
    @GetMapping
    public String index(){ 


        
        return "index";
    }
}
