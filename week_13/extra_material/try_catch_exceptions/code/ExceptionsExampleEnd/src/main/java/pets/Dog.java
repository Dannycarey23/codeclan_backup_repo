package pets;

import behaviours.Pet;

public class Dog implements Pet {
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
