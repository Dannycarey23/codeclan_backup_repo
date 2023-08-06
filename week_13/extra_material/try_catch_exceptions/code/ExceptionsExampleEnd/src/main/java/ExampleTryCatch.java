import exceptions.NullStringException;
import pets.Cat;
import pets.Dog;
import pets.Fish;

public class ExampleTryCatch{
    PetShop shop;

    public void run(){
        setup();

        try{
            shop.findPetByName(null);
        }
        // ex name for the caught Exception is convention
        catch (NullStringException ex) {
            ex.printStackTrace();
            System.out.println("Exception Message:");
            System.out.println(ex.getMessage());
        }
        // // optionally: handle different types of exceptions differently
        // catch (ADifferentKindOfException e){
        //   System.out.println(e.getMessage());
        // }
        finally{
            // optionally: clear up after yourself, closing db conncetion etc.
            // finally block runs regardless of whether an exception was thrown or not
            System.out.println("and finally...");
            System.out.println("I'm done.");
        }
    }

    public void setup(){
        shop = new PetShop();
        shop.addPet(new Dog("RoveR"));
        shop.addPet(new Cat("meowintons"));
        shop.addPet(new Fish("FINlay"));
    }
}