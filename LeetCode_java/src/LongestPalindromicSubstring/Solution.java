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
    // public String longestPalindrome(String s) {
    //     int i , j, flag;
    //     String ret = "";
    //     for(i = 0; i < s.length(); i = i + 1){
    //         for(j = i ; j < s.length(); j = j + 1){
    //             flag = 0;
    //             if(s.charAt(j) == s.charAt(i)){
    //                 flag = 1;
    //                 for (int k = 1; k <= (j - i) / 2; k = k + 1) {
    //                     if (s.charAt(i + k) != s.charAt(j - k)) {
    //                         flag = 0;
    //                     }
    //                 }
    //             }
    //             if (flag == 1 && (j - i + 1 ) > ret.length()){
    //                 ret = s.substring(i, j + 1);
    //             }
    //         }
    //     }
    //     return ret;
    // }


    // 中心扩展法，O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
