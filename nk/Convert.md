## 问题描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
```
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
```
## 代码实现
```
public class Solution {
    TreeNode leftHead = null;
    TreeNode rightHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(rightHead == null){
            leftHead = rightHead = pRootOfTree;
        } else{
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return leftHead;
    }
}
```