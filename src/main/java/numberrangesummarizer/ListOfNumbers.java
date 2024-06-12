/**
* @author: Houston Yu
* Date: 09/06/2024
*/

package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

// This class implements the methods from NumberRangeSummarizer interface
public class ListOfNumbers implements NumberRangeSummarizer {

    // Collect string input
    public Collection<Integer> collect(String input) {

        // Check whether the string is empty
        if (input.isEmpty())
            throw new IllegalArgumentException("String is empty");

        Collection<Integer> ListOfNumbers = new ArrayList<Integer>();
        String[] numberArray = input.split(","); // Create a string array from the input
        int num;

        // Check whether the input contains any invalid values
        try {
            for (int i=0; i<numberArray.length; i++) {
                numberArray[i] = numberArray[i].trim(); // Remove any leading or trailing spaces
                num = Integer.parseInt(numberArray[i]); // Convert the elements in the string array to integer
                ListOfNumbers.add(num);
            }
        } catch (NumberFormatException error) { // Validates the input (No letters,decimals and unique characters)
            System.out.println("Error: Please enter numeric integers. No alphabet letters, decimals or any special characters allowed.");
            throw error;
        }

        return ListOfNumbers;
    }

    // Create a summarized string
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> numberList = new ArrayList<Integer>(input);
        ArrayList<String> result = new ArrayList<String>();
        // Start and end will be used to track the positions of integer arrayList
        int start = numberList.getFirst();
        int end = start;

        // Loop through the arrayList to determine whether to group numbers into a range
        for (int i = 1; i<numberList.size(); i++) {
            int current = numberList.get(i);
            // Checks if the current integer is sequential and if it is also sequential in descending order
            if (current != end + 1 && current != end - 1 ) {
                addCommaOrHyphen(result, start, end); // if not sequential or the sequence has reached its end, call the utility function
                start = current;
            }
            // if sequential, just set the end variable to the current value of the arrayList while the start variable stays the same
            // This will be used to keep track of positions at which the number sequence will end
            end = current;
        }
        addCommaOrHyphen(result, start, end); // used to check the last element of the integer ArrayList

        // add comma to each number in the string arrayList to produce the final string
        return String.join(", ", result);


    }

    // Utility function to add comma or hyphen to the string
    public void addCommaOrHyphen(ArrayList<String> result, int start, int end) {

        // If start and end aren't the same, this indicates that integers are sequential and have been grouped into a range
        if (start != end) {
            result.add(start + "-" + end);
        } else { // If start and end are the same, it indicates that there is no sequence or the sequence has come to an end
            result.add(Integer.toString(start));
        }
    }
}

