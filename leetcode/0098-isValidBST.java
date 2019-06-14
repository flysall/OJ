/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode cur = root, pre = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (cur != null || !nodeStack.empty()) {
            while (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.pop();
            if (pre != null && pre.val >= cur.val)
                return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}

