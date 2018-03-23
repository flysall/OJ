/**Defition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if(root == null) return res;
        String operator = "->";
        StringBuffer current = new StringBuffer();
        path(root, current, res, operator);
        return res;
    }
    public void path(TreeNode root, StringBuffer current, List<String> res, String operator){
        if(root == null) return;
        int len = current.length();
        if(current.length() == 0)
            current.append(root.val);
        else
            current.append(operator + root.val);
        if(root.left == null && root.right == null)
            res.add(current.toString());
        path(root.left, current, res, operator);
        path(root.right, current, res, operator);
        if(current.length() > len)
            current.delete(len, current.length());
    }
}
