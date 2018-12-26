## 问题描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
```
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
```

## 代码实现
```java
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> nodeValues = new ArrayList<>();
        if(root == null)
            return nodeValues;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            nodeValues.add(curNode.val);
            if(curNode.left != null)
                queue.add(curNode.left);
            if(curNode.right != null)
                queue.add(curNode.right);
        }
        return nodeValues;
    }
}
```
