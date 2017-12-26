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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int curLevelNum = queue.size();
            List<Integer> item = new ArrayList();
            for(int i = 0; i < curLevelNum; i++){
                if(queue.peek().left != null) 
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                item.add(queue.poll().val);
            }
            list.add(item);
        }
        return list;
    }
}
