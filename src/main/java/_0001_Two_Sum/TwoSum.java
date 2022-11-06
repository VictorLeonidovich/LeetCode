package _0001_Two_Sum;


/**
 * @See https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result = new int[]{i, j};
                }
            }
        }
        //System.out.println("result=" + Arrays.toString(result));
        return result;
    }
}
