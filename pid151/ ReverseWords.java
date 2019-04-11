package pid151;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an input string, reverse the string word by word.
Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

class ReverseWords{

    private static String reverse(String s){
        String res = "";
        if(s.length() == 0) return "";
        Deque<String> stack = new ArrayDeque<String>();
        // 入栈
        for(int font = 0; font < s.length(); ){
            String temp = "";
            while(font < s.length() && s.charAt(font) != ' '){
                temp += s.charAt(font);
                font++;
            }
            // System.out.println(temp);
            if(temp.length() > 0)
                stack.addFirst(temp);
            font++;
        }
        while(!stack.isEmpty()){
            res += stack.poll();
            if(stack.size() > 0)
                res += " ";
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "";
        String res = reverse(s);
        System.out.println(res);
    }
}