/**
 * Hard 3:
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Logic: We use dynamic programming technique to store the already processed results so that we can reduce the processing time of duplicate sub-problems.
 *
 * Algorithm:
 * Step 1: Create a limit array with the length as number of digits in the input number.
 * Step 2: Create a dp array to store the results of the sub-problems.
 * Step 3: Find the number of ones in the input number by looping the number digit by digit.
 * Step 4: Return the result.
 */

public class Hard_3 {

  private static int[] getLimitArray(int n) {
    String num = n + "";
    int[] limits = new int[num.length()];
    for(int i = 0; i<num.length(); i++) {
      limits[i] = Character.getNumericValue(num.charAt(i));
    }
    return limits;
  }

  public static int findOnes(int n) {
    int[] limits = getLimitArray(n);
    int[][][] dp = new int[limits.length+1][2][limits.length+2];

    for(int index = limits.length; index >= 0; index--) {
      for(int flag = 0; flag <= 1; flag++) {
        for(int count = limits.length; count >= 0; count--) {
          if(index == limits.length) {
            dp[index][flag][count] = count;
          } else {
            int result = 0;
            if(flag == 1) {
              for(int i = 0; i <= limits[index]; i++) {
                int newCount = count;
                if(i == 1)
                  newCount++;
                if(i == limits[index]) {
                  result += dp[index+1][1][newCount];
                } else {
                  result += dp[index+1][0][newCount];
                }
              }
            } else {
              for(int i = 0; i <= 9; i++) {
                int newCount = count;
                if(i == 1)
                  newCount++;
                result += dp[index+1][0][newCount];
              }
            }
            dp[index][flag][count] = result;
          }
        }
      }
    }
    return dp[0][1][0];
  }

  public static void main(String[] args) {
    int num = 13;
    int result = findOnes(num);
    System.out.println(result);
  }
}
