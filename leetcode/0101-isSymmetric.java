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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricSubTree(root.left, root.right);
    }
    private boolean isSymmetricSubTree(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot != null && rightRoot != null)
            if (leftRoot.val == rightRoot.val)
                return isSymmetricSubTree(leftRoot.left, rightRoot.right) && isSymmetricSubTree(leftRoot.right, rightRoot.left);
        if (leftRoot == null && rightRoot == null)
            return true;
        return false;
    }
}
