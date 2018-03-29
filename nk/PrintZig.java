import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(pRoot);
        boolean isLeft = true;
        while(!deque.isEmpty()) {
            int lo = 0, hi = deque.size()-1;
            ArrayList<Integer> item = new ArrayList<>();
            if(isLeft) {
                while(lo <= hi) {
                    TreeNode cur = deque.pollFirst();
                    lo++;
                    item.add(cur.val);
                    if(cur.left != null) deque.addLast(cur.left);
                    if(cur.right != null) deque.addLast(cur.right);
                }
                isLeft = false;
            } else {
                while(lo <= hi) {
                    TreeNode cur = deque.pollLast();
                    hi--;
                    item.add(cur.val);
                    if(cur.right != null) deque.addFirst(cur.right);
                    if(cur.left != null) deque.addFirst(cur.left);
                }
                isLeft = true;
            }
            res.add(item);
        }
        return res;
    }
}