import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Stall> stalls;
    private ArrayList<Attraction> attractions;

    public ThemePark() {
        stalls = new ArrayList<Stall>();
        attractions = new ArrayList<Attraction>();
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }

    public int getAttractionCount(){
        return this.attractions.size();
    }

    public int getStallCount(){
        return this.stalls.size();
    }

    public ArrayList<IReviewed> getReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<IReviewed>();
        reviewed.addAll(this.attractions);
        reviewed.addAll(this.stalls);
        return reviewed;
    }

//  let's make a function that returns an ArrayList of IReviewed objects
//  it will take in a visitor since that's what it needs to evaluate whether
//  they can go on them
    public ArrayList<IReviewed> getAllAllowed(Visitor visitor) {
//      since we are returning an AL of IR objects, we will make one
        ArrayList<IReviewed> allowedAttractions = new ArrayList<IReviewed>();
//      we will go through all the Reviewed attractions by making a for loop
//      that goes through all IR items, each of them being called place
        for (IReviewed place : getReviewed()){
//          if one of the attractions is an IS, therefore they have restrictions
            if (place instanceof ISecurity){
//              we will need to check for every place if our visitor is allowed there
//              but if we look at line 51 we can see that place is an IR
//              so to treat them as an IS, we need to do something called casting
                if (((ISecurity) place).isAllowed(visitor)){
//                  if it meets the check then we add it to our list
                    allowedAttractions.add(place);
                }
            } else {
//              if it doesn't have an IS then we know that he can access it regardless
//              so we can add it to our allowed list
                allowedAttractions.add(place);
            }
        }

        return allowedAttractions;
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.addVisitedAttraction(attraction);
    }

    public HashMap<String, Integer> allReviews(){
       HashMap<String, Integer> reviews = new HashMap<String, Integer>();;
        for (IReviewed reviewed: getReviewed() ){
            reviews.put(reviewed.getName(), reviewed.getRating());
        }
        return reviews;
    }
}
