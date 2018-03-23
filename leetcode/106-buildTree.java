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
    int pInorder, pPostorder;
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end){
        if(pPostorder < 0)
            return null;
        TreeNode n = new TreeNode(postorder[pPostorder--]);
        if(inorder[pInorder] != n.val){
            n.right = buildTree(inorder, postorder, n);
        }
        pInorder--;
        if((end == null) || (inorder[pInorder] != end.val))
            n.left = buildTree(inorder, postorder, end);
        return n;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return buildTree(inorder, postorder, null);
    }
}