package pets;

import behaviours.Pet;

public class Fish implements Pet {
    private String name;

    public Fish(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
