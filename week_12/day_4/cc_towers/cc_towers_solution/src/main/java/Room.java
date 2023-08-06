import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int guestListSize(){
        return this.guests.size();
    }

    public void checkInGuest(Guest guest) {
        if (this.guestListSize() < this.capacity) {
            this.guests.add(guest);
        }
    }

    public void checkOutGuests() {
        if (this.isOccupied()) {
            this.guests.clear();
        }
    }

    public boolean isOccupied() {
        return this.guestListSize() > 0;
    }

    public boolean isVacant() {
        return this.guestListSize() == 0;
    }

    public static double calculateRoomSize(double length, double width){
        return length * width;
    }
}
