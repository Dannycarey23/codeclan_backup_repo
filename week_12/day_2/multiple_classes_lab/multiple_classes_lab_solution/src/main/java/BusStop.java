import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name) {
        this.name = name;
        this.queue = new ArrayList<Person>();
    }

    public int queueSize(){
        return this.queue.size();
    }


    public void add(Person person){
        this.queue.add(person);
    }

    public Person removeFromQueue() {
        Person personRemoved = null;
        if(this.queueSize() > 0){
            personRemoved = this.queue.remove(0);
        }
        return personRemoved;
    }
}
