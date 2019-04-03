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
    public List<TreeNode> generateTrees(int n) {
        return n <= 0 ? new ArrayList<TreeNode>() : generateBst(1, n);
    }
    private List<TreeNode> generateBst(int left, int right) {
        List<TreeNode> trees = new ArrayList<>();
        if (left > right) {
            trees.add(null);
        } else if (left == right) {
            TreeNode root = new TreeNode(left);
            trees.add(root);
        } else if (left < right) {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = generateBst(left, i-1);
                List<TreeNode> rightTrees = generateBst(i+1, right);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode curRoot = new TreeNode(i);
                        curRoot.left = leftTree;
                        curRoot.right = rightTree;
                        trees.add(curRoot);
                    }
                }
            }
        }
        return trees;
    }
}
