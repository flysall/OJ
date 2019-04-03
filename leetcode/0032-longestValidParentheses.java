class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int left = -1, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                stack.push(i);
            else {
                if (stack.empty()) 
                    left = i;
                else {
                    stack.pop();
                    if (stack.empty()) {
                        int curLen = i - left;
                        len = Math.max(curLen, len);
                    }                        
                    else {
                        int curLen = i - stack.peek();
                        len = Math.max(curLen, len);
                    }
                }
            }
        }
        return len;
    }
}
