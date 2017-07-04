import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Tests the Anagarm class
 */
public class AnagramTest {

    private Anagram anagram;
    private ArrayList<String> params;
    private String input = "Pool";

    @Before
    public void setUp() {
        //Arraylist of random inputs
        params = new ArrayList<String>();

        //Generate j amounts of i letter words
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <=5; j++) {
                String string = Helpers.randomString(i);
                params.add(string);
            }
        }
    }

    @Test
    public void testGenerate() throws Exception {
        try {
            for (String param : params) {
                anagram = new Anagram(param);
                List list = anagram.generate();
                for (Object object : list) {
                    System.out.println(param + " " + object.toString());
                    assertTrue("Generate does not work",Helpers.isAnagram(param, object.toString()));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @After
    public void tearDown() throws Exception {
        anagram = null;
    }
}