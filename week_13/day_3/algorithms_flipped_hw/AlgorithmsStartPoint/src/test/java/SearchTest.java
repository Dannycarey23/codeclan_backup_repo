import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {

    Search search;
    ArrayList<Integer> myNumbers;


    @Before
    public void before(){
        search = new Search();
        myNumbers = new ArrayList<Integer>();
        myNumbers.add(1);
        myNumbers.add(3);
        myNumbers.add(7);
        myNumbers.add(8);
        myNumbers.add(9);
        myNumbers.add(21);
        myNumbers.add(23);
        myNumbers.add(45);
        myNumbers.add(56);
    }

//    @Test
//    public void linearSearchFound(){
//        boolean result = search.linearSearch(myNumbers, 9);
//        assertTrue(result);
//    }
//
//    @Test
//    public void linearSearchNotFound(){
//        boolean result = search.linearSearch(myNumbers, 34);
//        assertFalse(result);
//    }
//
//    @Test
//    public void BinarySearchFound(){
//        boolean result = search.binarySearch(myNumbers, 21);
//        assertTrue(result);
//    }
//
//    @Test
//    public void binarySearchNotFound(){
//        boolean result = search.binarySearch(myNumbers, 4);
//        assertFalse(result);
//    }


}
