/**
 * @author: Houston Yu
 * Date: 09/06/2024
 */

package numberrangesummarizer;

import java.util.Collection;
import java.util.Scanner;

// driver class
public class Main{

    public static void main(String[] args) {
        ListOfNumbers list = new ListOfNumbers();

        // ask user for input
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a list of numbers separated by commas:");
        String input = myScanner .nextLine();

        // alternatively, if you don't want user to enter input just use the uncomment the code below
        //Collection<Integer> result = list.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Collection<Integer> result = list.collect(input);
        System.out.println(list.summarizeCollection(result));
    }

}
