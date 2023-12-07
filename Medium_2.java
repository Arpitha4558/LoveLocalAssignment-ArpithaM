import java.util.ArrayList;
import java.util.List;

/**
 * Medium 2:
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Solution:
 * Logic: To solve this problem efficiently we use Boyer-Moore Majority Voting algorithm.
 * This algorithm is used to find the potential majority elements and then verify if the elements occurrences are more than n/3.
 *
 * Algorithm:
 * Step 1: Create two counter variables to count the top 2 majority elements.
 * Step 2: Traverse through the array to find the potential majority elements.
 * Step 3: Verify if the majority elements are occurring more than n/3 times.
 * Step 4: Return the elements which are occurring more than n/3 times.
 */

public class Medium_2 {

  public static List<Integer> findElements(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int count1 = 0, count2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (count1 == 0 && ele2 != nums[i] ) {
        ele1 = nums[i];
        count1++;
      } else if (count2 == 0 && ele1 != nums[i]) {
        ele2 = nums[i];
        count2++;
      } else if (nums[i] == ele1) count1++;
      else if (nums[i] == ele2) count2++;
      else {
        count1--;
        count2--;
      }
    }

    count1 = 0;
    count2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (ele1 == nums[i]) count1++;
      if (ele2 == nums[i]) count2++;
    }

    if (count1 > nums.length/3) ans.add(ele1);
    if (count2 > nums.length/3) ans.add(ele2);

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2};
    List<Integer> result = findElements(nums);
    System.out.println(result);
  }

}
