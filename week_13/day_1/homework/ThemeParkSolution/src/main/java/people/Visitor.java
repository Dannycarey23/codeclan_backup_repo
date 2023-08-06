package people;

import attractions.Attraction;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private int height;
    private double money;
    private ArrayList<Attraction> visitedAttractions;

    public Visitor(int age, int height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<Attraction>();
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public void addVisitedAttraction(Attraction attraction){
        this.visitedAttractions.add(attraction);
    }

    public int getAttractionCount() {
        return this.visitedAttractions.size();
    }
}
