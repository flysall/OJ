import java.util.*;

/**
 * 寻找两个节点的最近公共父节点。
 */
public class BTNearestPublicParent {
    // 递归版本。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root = q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return (l != null && r != null) ? root : l == null ? r : l;
    }

    // 非递归版本
    
}
