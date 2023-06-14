package sg.sunilsingh.pokedex.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.sunilsingh.pokedex.model.Pokemon;

@Service
public class PokedexService {

    final String apiURL = "https://pokeapi.co/api/v2/";
    
    public List<Pokemon> getPokemonData() {

        List<Pokemon> pokemonData = new ArrayList<>();
        RestTemplate template = new RestTemplate();

        // build first JSON URL to retrieve name and ID
        String firstURL = UriComponentsBuilder.fromUriString(apiURL + "pokemon/?limit=150").toUriString();
        ResponseEntity<String> firstResponse = template.getForEntity(firstURL, String.class);
        JsonReader firstReader = Json.createReader(new StringReader(firstResponse.getBody()));
        JsonObject firstObj = firstReader.readObject();
        JsonArray resultsArray = firstObj.getJsonArray("results");

        // iterate through each result in the array and assign to a new Pokemon instance
        for (int i = 0; i < resultsArray.size(); i++) {
            Pokemon p = new Pokemon();
            p.setId(resultsArray.get(i).asJsonObject().getString("url").substring(34, resultsArray.get(i).asJsonObject().getString("url").length() - 1));
            p.setName(resultsArray.get(i).asJsonObject().getString("name"));
            pokemonData.add(p);
        }

        // build second JSON URL to retrieve type(s) of specified Pokemon
        for (Pokemon p : pokemonData) {
            String secondURL = apiURL + "pokemon/" + p.getId();
            ResponseEntity<String> secondResponse = template.getForEntity(secondURL, String.class);
            JsonReader secondReader = Json.createReader(new StringReader(secondResponse.getBody()));
            JsonObject secondObj = secondReader.readObject();
            JsonArray typesArray = secondObj.getJsonArray("types");

            for (int i = 0; i < typesArray.size(); i++) {
                p.setType(p.getType() + typesArray.get(i).asJsonObject().getJsonObject("type").getString("name") + ", ");
            }

            JsonObject sprites = secondObj.getJsonObject("sprites");
            p.setImageURL(sprites.getString("front_default"));
        }

        return pokemonData;
    }

}

