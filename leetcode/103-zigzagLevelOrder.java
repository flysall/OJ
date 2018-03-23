/**
 * Defition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean order = true;
        int size = 1;
        while(!q.isEmpty()){
            List<Integer> item = new ArrayList();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(order)
                    item.add(cur.val);
                else
                    item.add(0, cur.val);
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            list.add(item);
            size = q.size();
            order = order ? false : true;
        }
        return list;
    }
}
