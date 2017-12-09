class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        for(char tmp : s.toCharArray()){
            if(tmp == '(' || tmp == '[' || tmp == '{')
                stack.push(tmp);
            else if(tmp == ')' || tmp == ']' || tmp == '}')
                if(stack.empty()) return false;
                else if (!Solution.equal(stack.pop(), tmp)) return false;
        }
        if(!stack.empty()) return false;
        return true;
    }

    private static boolean equal(char first, char second){
        if(first == '(' && second == ')') return true;
        if(first == '[' && second == ']') return true;
        if(first == '{' && second == '}') return true;
        return false;
    }

}
