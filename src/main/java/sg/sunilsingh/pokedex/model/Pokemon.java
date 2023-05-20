package sg.sunilsingh.pokedex.model;

public class Pokemon {

    private String name;
    private String description;
    private String imageURL;

    public Pokemon() {
    }

    public Pokemon(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Pokemon [name=" + name + ", description=" + description + ", imageURL=" + imageURL + "]";
    }

}
