/* Defition for a binary tree node.
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
        List<TreeNode> nodes = new ArrayList<>();
        if (left > right)
            nodes.add(null);
        for (int i = left; i <= right; ++i) {
            List<TreeNode> leftNodes = generateBst(left, i-1);
            List<TreeNode> rightNodes = generateBst(i+1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
