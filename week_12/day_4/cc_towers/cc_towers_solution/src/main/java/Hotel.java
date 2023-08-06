import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;


    public Hotel() {
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.diningRooms = new HashMap<>();

    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        this.diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public Bedroom findBedroom(int roomNumber) {
        Bedroom foundRoom = null;
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.getRoomNumber() == roomNumber) {
                foundRoom = bedroom;
            }
        }
        return foundRoom;
    }

    public ConferenceRoom findConferenceRoom(String roomName) {
        ConferenceRoom foundRoom = null;
        for (ConferenceRoom conferenceRoom: this.conferenceRooms) {
            if (conferenceRoom.getName() == roomName) {
                foundRoom = conferenceRoom;
            }
        }
        return foundRoom;
    }

    public DiningRoom findDiningRoom(String roomName) {
        return diningRooms.get(roomName);
    }

    public void checkInGuestsToBedroom(int roomNumber, ArrayList<Guest> guests) {
        Bedroom bedroom = findBedroom(roomNumber);
        if (bedroom != null && bedroom.isVacant()) {
            for (Guest guest: guests) {
                bedroom.checkInGuest(guest);
            }
        }
    }

    public void checkOutGuestsFromBedroom(int roomNumber) {
        Bedroom bedroom = findBedroom(roomNumber);
        if (bedroom != null) {
            bedroom.checkOutGuests();
        }
    }

    public void checkInGuestsToDiningRoom(String roomName, ArrayList<Guest> guests) {
        DiningRoom diningRoom = findDiningRoom(roomName);
        if (diningRoom != null) {
            for (Guest guest : guests){
                diningRoom.checkInGuest(guest);
            }
        }
    }

    public void checkOutGuestsFromDiningRoom(String roomName) {
        DiningRoom diningRoom = findDiningRoom(roomName);
        if (diningRoom != null) {
            diningRoom.checkOutGuests();
        }
    }

    public void checkInGuestsToConferenceRoom(String roomName, ArrayList<Guest> guests) {
        ConferenceRoom conferenceRoom = findConferenceRoom(roomName);
        if (conferenceRoom != null) {
            for (Guest guest : guests) {
                conferenceRoom.checkInGuest(guest);
            }
        }
    }

    public void checkOutGuestsFromConferenceRoom(String roomName) {
        ConferenceRoom conferenceRoom = findConferenceRoom(roomName);
        if (conferenceRoom != null) {
            conferenceRoom.checkOutGuests();
        }
    }

    public Booking createBooking(Bedroom bedroom, int numOfNights) {
        Booking booking = new Booking(numOfNights, bedroom);
        return booking;
    }

    public ArrayList<Bedroom> findVacantBedrooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<Bedroom>();
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.isVacant()) {
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }

}
