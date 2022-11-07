package _0014_Longest_Common_Prefix;

/**
 * @See https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int strsLength = strs.length;
        String firstWord = strs[0];
        for (int i = 0; i < firstWord.length(); i++){
            char firstWordChar = strs[0].charAt(i);
            //System.out.println("firstWordChar=" + firstWordChar);
            int count = 1;
            for(int j = 1; j < strsLength; j++){
                if(strs[j].length() > i && strs[j].charAt(i) == firstWordChar){
                    count++;
                }
            }
            if(count == strsLength){
                result += firstWordChar;
            }else{
                break;
            }
        }

        return result;
    }
}
