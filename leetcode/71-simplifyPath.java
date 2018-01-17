class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList();
        Set<String> skipSet = new HashSet(Arrays.asList("..", ".", ""));
        for(String s : path.split("/")){
            if(s.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!skipSet.contains(s))
                stack.push(s);
        }
        String re = "";
        for(String s : stack)
            re = "/" + s + re;
        return re.isEmpty() ? "/" : re;
    }
}
