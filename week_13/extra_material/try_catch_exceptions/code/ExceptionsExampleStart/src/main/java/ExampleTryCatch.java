import pets.Cat;
import pets.Dog;
import pets.Fish;

public class ExampleTryCatch{
    PetShop shop;

    public void run(){
        setup();
        shop.findPetByName(null);

    }

    public void setup(){
        shop = new PetShop();
        shop.addPet(new Dog("RoveR"));
        shop.addPet(new Cat("meowintons"));
        shop.addPet(new Fish("FINlay"));
    }
}