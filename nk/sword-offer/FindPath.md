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

## 思路
> 带记忆的DFS

## 代码实现：
### Java代码
```java
import java.util.*;

public class Solution {
    private ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null)
            return allPaths;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            allPaths.add(new ArrayList<Integer>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size()-1);
        return allPaths;
    }
}
```
### C++代码
```cpp
/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution {
public:
    vector<vector<int> > FindPath(TreeNode* root,int expectNumber) {
        vector<vector<int>> ret;
        vector<int> trace;
        if (root)
            dfs(root, expectNumber, ret, trace);
        return ret;
    }
    void dfs(TreeNode* root, int s, vector<vector<int>> &ret, vector<int> &trace) {
        trace.push_back(root->val);
        if (!root->left && !root->right && s == root->val) {
            ret.push_back(trace);
        }
        if (root->left)
            dfs(root->left, s - root->val, ret, trace);
        if (root->right)
            dfs(root->right, s - root->val, ret, trace);
        trace.pop_back();
    }
};
```