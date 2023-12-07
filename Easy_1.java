/**
 * Easy 1:
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal
 * substring consisting of non-space characters only.
 *
 * Solution:
 * Logic: Split the input string into array of words and return the length of the last element of the array
 *
 * Algorithm:
 * Step 1: Split the input string into words by using whitespace as the delimiter.
 *         String.split() function from Java is used to split the input string into words.
 * Step 2: Fetch the last element in the array of words.
 * Step 3: Return the length of the word that is fetched from the array in the step 2.
 */

public class Easy_1 {

  public static String lastWord(String str) {
    String[] words = str.split(" ");
    return words[words.length-1];
  }

  public static void main(String[] args) {
    String result = lastWord("   fly me   to   the moon  ");
    System.out.println(result.length());
  }

}
