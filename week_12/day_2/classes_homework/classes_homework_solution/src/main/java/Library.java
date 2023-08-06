import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int capacity;
    private ArrayList<Book> collection;
    private HashMap<String, Integer> genreHashmap;

    public Library(int capacity) {
        this.capacity = capacity;
        this.collection = new ArrayList<>();
        this.genreHashmap = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasCapacity() {
        return capacity > collection.size();
    }

    public int bookCount() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        if(hasCapacity()){
            this.collection.add(book);
            this.addToGenreHashmap(book);
        }
    }

    public void addToGenreHashmap(Book book){

        String genre = book.getGenre();

        //if the genre already exists in the hashmap, extract the existing count and assign it to the variable 'counter'
        if(this.genreHashmap.containsKey(genre)){
            int counter = genreHashmap.get(genre);

            // add one to the counter
            counter++;

            //put the key and new value back into the hashmap
            this.genreHashmap.put(genre, counter);

        } else {

            this.genreHashmap.put(genre, 1);
        }
    }

    public void loanBook(Book book, Borrower borrower) {
        // check if book in book collection
        if(this.collection.contains(book)){
            // if it is, remove book from collection
            this.collection.remove(book);

            // add to borrower
            borrower.addBook(book);
        }
    }

    public boolean checkInStock(Book book) {
//        return this.collection.contains(book);
        for(Book individualBook:this.collection){
            if(individualBook == book){
                return true;
            }
        }
        return false;
    }

    public int checkGenreFrequency(String genre) {
        return this.genreHashmap.get(genre);
    }
}
