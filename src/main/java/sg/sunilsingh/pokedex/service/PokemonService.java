package sg.sunilsingh.pokedex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.sunilsingh.pokedex.model.PokemonApiResponse;
import sg.sunilsingh.pokedex.model.PokemonResult;

@Service
public class PokemonService {
    
    public List<String> getPokemonNames() {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/?limit=150";
        
        RestTemplate restTemplate = new RestTemplate();
        PokemonApiResponse response = restTemplate.getForObject(apiUrl, PokemonApiResponse.class);

        List<String> pokemonNames = new ArrayList<>();
        if (response != null && response.getResults() != null) {
            for (PokemonResult result : response.getResults()) {
                pokemonNames.add(result.getName());
                pokemonNames.add(result.getUrl().replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", ""));
            }
        }

        return pokemonNames;
    }
}

