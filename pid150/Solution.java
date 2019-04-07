package pid150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] operaters = {"+","-","*","/"};
        HashSet<String> set = new HashSet<>(Arrays.asList(operaters));

        for(int i = 0;i < tokens.length; i++){
            if(set.contains(tokens[i])){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(operater(a, b, tokens[i]));
            }else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String operater(int a, int b, String op){
        switch (op){
            case "+":   return String.valueOf(a + b);   
            case "-":   return String.valueOf(a - b);
            case "*":   return String.valueOf(a * b);  
            case "/":   return String.valueOf(a / b); 
            default:    throw new IllegalArgumentException("error");
        }

    }
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(new Solution().evalRPN(tokens1));
        System.out.println(new Solution().evalRPN(tokens2));
        System.out.println(new Solution().evalRPN(tokens3));

    }
}