import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCollectionTest {
    WordCollection myWords;

    @Before
    public void before(){
        myWords = new WordCollection();
    }

    @Test
    public void canGetWordCount(){
        assertEquals(5, myWords.getWordCount());
    }
}
