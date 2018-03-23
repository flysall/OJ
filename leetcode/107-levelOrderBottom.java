/**Defition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList();
        levelMarker(wrapList, root, 0);
        return wrapList;
    }
    public void levelMarker(List<List<Integer>> list, TreeNode root, int level){
        if(root == null) return;
        if(level >= list.size())
            list.add(0, new LinkedList<Integer>());
        levelMarker(list, root.left, level+1);
        levelMarker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
