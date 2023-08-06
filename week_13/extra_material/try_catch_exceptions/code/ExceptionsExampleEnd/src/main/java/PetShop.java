import behaviours.Pet;
import exceptions.NullStringException;

import java.util.ArrayList;

public class PetShop{

    private ArrayList<Pet> stock;

    public PetShop(){
        stock = new ArrayList<Pet>();
    }
    // Add the throws keyword to warn the dev who's using our method
    public Pet findPetByName(String searchName) throws NullStringException {
        // Add an if statement to check the input as soon as you get it.
        // If the input is null, we can't do anything with it
        // We can't even search for a pet with that name, as it's not a valid String
        // So we throw our Exception, to explain what's wrong to the dev using our function.
        if (searchName == null){
            throw new NullStringException("Cannot search for a pet with null instead of a name String");
        }

        String searchLower = searchName.toLowerCase();
        for (Pet pet : stock){
            String petName = pet.getName().toLowerCase();
            if (petName.equals(searchLower)){
                return pet;
            }
        }
        // returns null if the pet's not found but the input was valid.
        return null;
    }

    public void addPet(Pet pet){
        stock.add(pet);
    }

}