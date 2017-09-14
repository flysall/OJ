## 问题描述：
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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
## 代码实现：
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Traversal(root, target, array, result);
        return result;
    }
    private void Traversal(TreeNode root, int target, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result){
        target -= root.val;
        array.add(root.val);
        if(root.left == null && root.right == null && target == 0)
            result.add(array);
        if(root.left != null){
            ArrayList<Integer> array1 = new ArrayList<Integer>();
            array1 = (ArrayList<Integer>) array.clone();
            Traversal(root.left, target, array1, result);
        }
        if(root.right != null){
            ArrayList<Integer> array1 = new ArrayList<Integer>();
            array1 = (ArrayList<Integer>) array.clone();
            Traversal(root.right, target, array1, result);
        }
    }
}
```

list.remove(list.size() - 1);简直妙！
```
public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
```

