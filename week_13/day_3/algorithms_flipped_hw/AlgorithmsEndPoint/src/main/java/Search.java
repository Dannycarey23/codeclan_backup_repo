import java.util.ArrayList;

public class Search {

    public Boolean linearSearch(ArrayList<Integer> array, int searchNumber) {
        for (int number : array)
            if (number == searchNumber){
                return true;
            }
        return false;
    }

    public static Boolean binarySearch(ArrayList<Integer> array, int searchNumber){
        if (array.size() == 0){
            return false;
        }

        int midIndex = 0;
        if (array.size() >1) {
            midIndex = (int) Math.ceil((double) array.size() / 2);
        }

        int midPoint = array.get(midIndex);

        if (searchNumber == midPoint){
            return true;
        }

        ArrayList<Integer> newSearchArea;

        if (searchNumber < midPoint){
            newSearchArea = new ArrayList<Integer>(array.subList(0, midIndex));
        } else {
            newSearchArea = new ArrayList<Integer>(array.subList(midIndex + 1, array.size()));
        }
        return binarySearch(newSearchArea, searchNumber);
    }


}
