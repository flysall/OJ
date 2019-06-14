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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexs = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexs.put(inorder[i], i);
        return buildTree(0, 0, inorder.length-1, preorder, inorder, inorderIndexs);
    }
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderIndexs) {
        if (preStart > preorder.length-1 || inStart > inEnd)
            return null;
        int val = preorder[preStart];
        int index = inorderIndexs.get(val);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preStart+1, inStart, index-1, preorder, inorder, inorderIndexs);
        root.right = buildTree(preStart+index-inStart+1, index+1, inEnd, preorder, inorder, inorderIndexs);
        return root;
    }
}
