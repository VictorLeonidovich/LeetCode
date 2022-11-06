package _0009_Palindrome_Number;

/**
 * @See https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        String xStrReverse = new StringBuilder(xStr).reverse().toString();
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (!(xStr.charAt(i) == xStrReverse.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
