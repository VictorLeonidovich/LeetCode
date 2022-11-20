package _0020_Valid_Parentheses;

import java.util.ArrayDeque;

/**
 * @See https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    private char[] open = new char[]{'(', '{', '['};
    private char[] closed = new char[]{')', '}', ']'};

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        boolean isValid = true;
        ArrayDeque<Character> parenthesesQueue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpen(ch)) {
                parenthesesQueue.addLast(ch);
            } else if (isClosed(ch)) {
                Character ch2 = parenthesesQueue.pollLast();
                if (ch2 != null) {
                    if (getIndex(ch2, open) != getIndex(ch, closed)) {
                        isValid = false;
                        break;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        if (parenthesesQueue.size() > 0) {
            isValid = false;
        }
        return isValid;
    }

    private boolean isOpen(char ch) {
        for (int i = 0; i < open.length; i++) {
            if (ch == open[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isClosed(char ch) {
        for (int i = 0; i < closed.length; i++) {
            if (ch == closed[i]) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(char ch, char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (ch == charArray[i]) {
                return i;
            }
        }
        return -1;
    }
}
