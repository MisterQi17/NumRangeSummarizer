/**
 * @author: Houston Yu
 * Date: 09/06/2024
 */

package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

// unit tests
class ListOfNumbersTest {
    ListOfNumbers summarizer = new ListOfNumbers();
    Collection<Integer> numberCollection;

    @Test // Check if it gives errors when the input contains invalid values
    void testing_For_Letters_And_Special_Characters() {
        assertThrows(NumberFormatException.class,
                () -> {
                    summarizer.collect("1,3,A,&,4,*,(,sss");
                });
    }

    @Test // Add a comma when the next number is the same as the previous number in the sequence
    void testing_For_Same_Numbers() {
        numberCollection = summarizer.collect("1,3,3,6,7,8");
        assertEquals("1, 3, 3, 6-8", summarizer.summarizeCollection(numberCollection));
    }

    @Test // Negative integers can also be grouped into a range or seperated by a comma
    void testing_For_Negative_Integers() {
        numberCollection = summarizer.collect("-2,-1,0,4,-8,1");
        assertEquals("-2-0, 4, -8, 1", summarizer.summarizeCollection(numberCollection));
    }

    @Test // Numbers that are in descending order can also be grouped into a range
    void testing_For_Descending_Sequence() {
        numberCollection = summarizer.collect("3,2,1,6,-7,1");
        assertEquals("3-1, 6, -7, 1", summarizer.summarizeCollection(numberCollection));
    }

    @Test // Throws an error if there are decimals
    void testing_For_Decimals() {
        assertThrows(NumberFormatException.class,
                () -> {
                    summarizer.collect("3,5,12.5");
                });
    }

    @Test // Throws an error if the input is empty
    void testing_For_Empty_Input() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    summarizer.collect("");
                });
    }

    @Test // Check if the utility function can add a hyphen correctly
    void testing_utility_function_hyphen() {
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("1","3","3-5"));
        ArrayList<String> actual = new ArrayList<String>(Arrays.asList("1","3"));
        summarizer.addCommaOrHyphen(actual,3,5);
        assertEquals(expected, actual);
    }

    @Test // Check if the utility function can add a number to the arrayList
    void testing_utility_function_comma() {
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("1","3","6"));
        ArrayList<String> actual = new ArrayList<String>(Arrays.asList("1","3"));
        summarizer.addCommaOrHyphen(actual,6,6);
        assertEquals(expected, actual);
    }
}