/**
 * Given a string s, find the longest palindromic substring in s. 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
// 暴力循环 O(n^3)

package LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int i , j, flag;
        String ret = "";
        for(i = 0; i < s.length(); i = i + 1){
            for(j = i ; j < s.length(); j = j + 1){
                flag = 0;
                if(s.charAt(j) == s.charAt(i)){
                    flag = 1;
                    for (int k = 1; k <= (j - i) / 2; k = k + 1) {
                        if (s.charAt(i + k) != s.charAt(j - k)) {
                            flag = 0;
                        }
                    }
                }
                if (flag == 1 && (j - i + 1 ) > ret.length()){
                    ret = s.substring(i, j + 1);
                }
            }
        }
        return ret;
    }
}
