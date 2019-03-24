package pid22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {

    // 暴力求解，求出所有可能排列（不考虑 '(' 和')'的数量）——2^n 中可能，然后用 isValid 栈判断是否满足
    public List<String> generateParenthesis(int n) {
        if(n < 1){
            return null;
        }
        List<String> combinations = new LinkedList<>();
        generateAll(new char[2*n] , 0, combinations);
        return combinations;
    }
    // 递归公式： 排列n个字符 = {'(' + 排列剩下的 n-1 个字符  } + { ')' + 排列剩下的 n-1 个字符 }
    private void generateAll(char[] current, int pos, List<String> result){
        if(pos == current.length){
            if(isVaild(current)){
                result.add(new String(current));
            }
        }else{
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean isVaild(char[] current){
        List<Character> stack = new ArrayList<>();
        for (char c : current) {
            if(stack.size() == 0){
                if(c == ')'){
                    return false;
                }else{
                    stack.add(c);
                }
            }else{
                if(c == stack.get(stack.size() - 1)){
                    stack.add(c);
                }else{
                    stack.remove(stack.size() - 1);
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    

    // 直接保证了 '(' 后必然有一个对应的 ')'
    // public List<String> generateParenthesis(int n) {
    //     List<String> list = new ArrayList<String>();
    //     backtrack(list, "", 0, 0, n);
    //     return list;
    // }
    
    // public void backtrack(List<String> list, String str, int open, int close, int max){
        
    //     if(str.length() == max*2){
    //         list.add(str);
    //         return;
    //     }
        
    //     if(open < max)
    //         backtrack(list, str+"(", open+1, close, max);
    //     if(close < open)
    //         backtrack(list, str+")", open, close+1, max);
    // }

}