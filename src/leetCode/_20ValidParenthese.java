package leetCode;

import java.util.Stack;

public class _20ValidParenthese {

    /**
     * 比较重要的一点就是得想到用stack来解决，然后就是考虑各种corner case
     * 1：string 开头是右边的)}]然后stack为空
     * 2：遍历完了stack不为空
     */

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' ||s .charAt(i) == '{' ){
                stack.push(s.charAt(i));
                continue;
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if(s.charAt(i) == ']' && stack.peek() != '[' || s.charAt(i) == '}' && stack.peek() != '{' || s.charAt(i) == ')' && stack.peek() != '('){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }

    }
}
