import java.util.HashMap;

class Country {
    private String name;
    private long population;
    private String continent;
    private String capital;

    public Country(String name, long population, String continent, String capital) {
        this.name = name;
        this.population = population;
        this.continent = continent;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public String getCapital() {
        return capital;
    }
}