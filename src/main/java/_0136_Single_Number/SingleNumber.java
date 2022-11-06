package _0136_Single_Number;

import java.util.HashMap;
import java.util.Map;

/**
 * @See https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result = nums[i];
            if (table.containsKey(result)) {
                table.remove(result);
                //table.put(result, table.get(result) + 1);
            } else {
                table.put(result, 1);
            }
        }
        //System.out.println("table=" + table);

        //Iterator<Integer> itr = table.keySet().iterator();
        //while (itr.hasNext()){
        //    int key = itr.next();
        //    int value = table.get(key);
        //        //System.out.println("value=" + value);
        //    if(value == 1){
        //        //System.out.println("key=" + key);
        //        return key;
        //    }
        //}

        int key = (Integer) table.keySet().toArray()[0];
        //System.out.println("key=" + key);

        return key;
    }
}
