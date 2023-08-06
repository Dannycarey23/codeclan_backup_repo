import java.util.ArrayList;

public class DiningRoom extends Room {

    private String name;

    public DiningRoom(int capacity, String name) {
        super(capacity);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
