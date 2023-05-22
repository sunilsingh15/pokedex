package sg.sunilsingh.pokedex.model;

public class PokemonResult {
    private String name;
    private String url;

    public PokemonResult() {
    }

    public PokemonResult(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonResult [name=" + name + ", url=" + url + "]";
    }

}
