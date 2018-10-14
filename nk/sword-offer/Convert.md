## 问题描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
```

## 思路
二叉树中序遍历

## 代码实现

### 非递归版本
```java
import java.util.*;

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        boolean isListHead = true;
        TreeNode listHead = null, preNode = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isListHead) {
                listHead = p;
                preNode = listHead;
                isListHead = false;
            } else {
                preNode.right = p;
                p.left = preNode;
                preNode = p;
            }
            p = p.right;
        }
        return listHead;
    }
}
```

### 递归版本
```java
public class Solution {
    TreeNode leftHead = null;   // 双向链表头结点 
    TreeNode rightHead = null;  // 双向链表尾节点
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