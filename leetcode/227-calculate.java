class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        for(int i = 0, num = 0, op = '+'; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + (c - '0');
            if("+-*/".indexOf(c) >= 0 || i == s.length()-1){
                if("*/".indexOf(op) >= 0)
                    result -= stack.peek();
                switch(op){
                    case '+': stack.push(num);
                        break;
                    case '-': stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                op = c;
                result += stack.peek();
            }
        }
        return result;
    }
}
