import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push((int)s.charAt(i));
                continue;
            }
            if(s.charAt(i) == 40){
                stack.push(40);
            }else{
                if(stack.peek() == 40){
                    stack.pop();
                }else{
                    stack.push(41);
                }
            }
            // System.out.println(stack);
        }

        // System.out.println(stack);
        return stack.isEmpty();
    }
}