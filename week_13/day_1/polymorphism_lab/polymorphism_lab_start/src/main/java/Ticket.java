public class Ticket {
    private String bookingRef;
    private String qrCode;
    private String date;

    public Ticket(String bookingRef, String qrCode, String date) {
        this.bookingRef = bookingRef;
        this.qrCode = qrCode;
        this.date = date;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public String getDate() {
        return date;
    }

    public String scan() {
        return this.qrCode;
    }
}
