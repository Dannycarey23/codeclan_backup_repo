package pets;

import behaviours.Pet;

public class Cat implements Pet {
    private String name;

    public Cat(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
