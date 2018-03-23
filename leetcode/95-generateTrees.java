/**Defition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return getTrees(1, n);
    }
    private List<TreeNode> getTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
            list.add(null);
        if(start == end)
            list.add(new TreeNode(start));
        else{
            List<TreeNode> left, right;
            for(int i = start; i <= end; i++){
                left = getTrees(start, i-1);
                right = getTrees(i+1, end);
                for(TreeNode leftNode : left){
                    for(TreeNode rightNode : right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
