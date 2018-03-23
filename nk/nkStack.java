import java.util.Stack;

public class Solution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    public void push(int node) {
        data.push(node);
        if(mins.empty() || node < mins.peek())
            mins.push(node);
    }
    public void pop() {
        int val = data.pop();
        if(val == mins.peek())
            mins.pop();
    }
    public int top() {
        return data.peek();        
    }
    public int min() {
        return mins.peek();        
    }
}