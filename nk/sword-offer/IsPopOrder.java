import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0) 
            return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(i < pushA.length) {
            stack.push(pushA[i]);
            while(j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                ++j;
            }
            ++i;
        }
        return stack.isEmpty();
    }
}
