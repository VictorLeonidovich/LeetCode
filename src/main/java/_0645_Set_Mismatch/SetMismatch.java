package _0645_Set_Mismatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @See https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        /*if(nums[0] == 1 && nums.length == 2){
            return new int[]{1,2};
        }
        if(nums[0] == 2 && nums.length == 2){
            return new int[]{2,1};
        }
        if(nums.length > 2 && nums[0] < nums[1]){
            System.out.println("UpStream=" + Arrays.toString(nums));
            return handleUpStreamArray(nums);
        }
        if(nums.length > 2 && nums[0] > nums[1]){
            //System.out.println("DownStream=" + Arrays.toString(nums));
            return handleDownStreamArray(nums);
        }*/

        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 1; i < nums.length + 1; i++) {
            if (!arrayMap.containsKey(i)) {
                arrayMap.put(i, 1);
            } else {
                arrayMap.put(i, arrayMap.get(i) + 1);
            }
            if (!arrayMap.containsKey(nums[i - 1])) {
                arrayMap.put(nums[i - 1], 1);
            } else {
                arrayMap.put(nums[i - 1], arrayMap.get(nums[i - 1]) + 1);
            }
        }
        int duplicate = 0;
        int missed = 0;


        for (Map.Entry<Integer, Integer> entry : arrayMap.entrySet()) {
            if (entry.getValue() == 1) {
                missed = entry.getKey();
            }
            if (entry.getValue() == 3) {
                duplicate = entry.getKey();
            }
        }
        //System.out.println("return=" + Arrays.toString(new int[]{duplicate,missed}));
        return new int[]{duplicate, missed};
    }

    private int[] handleUpStreamArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i] + 1=" + (nums[i] + 1) + ", nums[i + 1]=" + nums[i + 1]);
            if ((nums[i] + 1) != nums[i + 1]) {
                System.out.println("return=" + Arrays.toString(new int[]{nums[i], nums[i] + 1}));
                return new int[]{nums[i], nums[i] + 1};
            }
        }
        return nums;
    }

    private int[] handleDownStreamArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("nums[i] - 1=" + (nums[i] - 1) + ", nums[i + 1]=" + nums[i + 1]);
            if ((nums[i] - 1) != nums[i + 1]) {
                //System.out.println("return=" + Arrays.toString(new int[] {nums[i], nums[i] - 1}));
                return new int[]{nums[i], nums[i] - 1};
            }
        }
        return nums;
    }

}
