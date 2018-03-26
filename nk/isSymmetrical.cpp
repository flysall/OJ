/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/
class Solution {
public:
    bool isSymmetrical(TreeNode* pRoot)
    {
        if(pRoot == NULL) return true;
        return isSym(pRoot->left, pRoot->right);
    }
    bool isSym(TreeNode* left, TreeNode* right) 
    {
        if(left == NULL && right == NULL)
            return true;
        if(left != NULL && right != NULL) {
            bool is_out = isSym(left->left, right->right);
            bool is_mid = left->val == right->val;
            bool is_in = isSym(left->right, right->left);
            return is_out && is_mid && is_in;
        } else {
            return false;
        }
    }
};