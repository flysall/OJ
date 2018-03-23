/**Defition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode pt = p, qt = q;
        if(pt != null && qt != null){
            if(pt.val != qt.val) return false;
            return isSameTree(pt.left, qt.left) && isSameTree(pt.right, qt.right); 
        }
        else if(pt == null && qt == null) return true;
        return false;
    }
}
