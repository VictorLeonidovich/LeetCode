package _0202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @ See https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
    private final int limit = (int) Math.pow(2, 31);
    private final Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (set.contains(n)) {
            return false;
        } else {
            set.add(n);
        }
        //System.out.println("n=" + n);
        int sum = 0;
        String nS = String.valueOf(n);
        //System.out.println("nS=" + nS);
        for (int i = 0; i < nS.length(); i++) {
            sum += (int) Math.pow(Integer.parseInt(String.valueOf(nS.charAt(i))), 2);
            //System.out.println("sum=" + sum);
        }
        if (sum == 1) {
            return true;
        }
        if (sum > limit) {
            return false;
        }

        //System.out.println("sum=" + sum);
        return isHappy(sum);
    }
}
