package products;

public class Crisps extends Product {

    private String flavour;

    public Crisps(String name, String flavour) {
        super(name);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }
}
