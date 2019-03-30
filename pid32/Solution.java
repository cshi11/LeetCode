package pid32;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0, max = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    count = i - stack.peek();
                    if(max < count) max = count;
                }  
            } 
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "()(()";
        String s2 = "((())((";
        String s3 = ")(";
        String s4 = "";

        System.out.println(new Solution().longestValidParentheses(s1));
        System.out.println(new Solution().longestValidParentheses(s2));
        System.out.println(new Solution().longestValidParentheses(s3));
        System.out.println(new Solution().longestValidParentheses(s4));
    }
}