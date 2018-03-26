public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = getDepth(root.left);
        if(leftHeight == -1) 
            return -1;
        int rightHeight = getDepth(root.right);
        if(rightHeight == -1)
            return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }
}