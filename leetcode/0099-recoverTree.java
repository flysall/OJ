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
    TreeNode preNode = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        traverse(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (preNode != null) {
            if (firstNode == null && preNode.val >= root.val)
                firstNode = preNode;
            if (firstNode != null && preNode.val >= root.val)
                secondNode = root;
        }
        preNode = root;
        traverse(root.right);
    }
}
