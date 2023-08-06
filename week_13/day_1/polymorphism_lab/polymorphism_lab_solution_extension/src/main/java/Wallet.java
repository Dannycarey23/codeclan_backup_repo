import java.util.ArrayList;

public class Wallet {
    private String name;
    private ArrayList<IScan> items;

    public Wallet(String name) {
        this.name = name;
        this.items = new ArrayList<IScan>();
    }

    public String getName() {
        return name;
    }

    public void addItem(IScan item) {
        this.items.add(item);
    }

    public int getNumberOfItems() {
        return this.items.size();
    }

    public String scanItem(int index) {
        IScan item = items.get(index);
        return item.scan();
    }
}
