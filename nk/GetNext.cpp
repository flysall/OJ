/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {
        
    }
};
*/
class Solution {
public:
    TreeLinkNode* GetNext(TreeLinkNode* pNode)
    {
        if(pNode == NULL) return NULL;
        if(pNode->right != NULL) {
            TreeLinkNode* c = pNode->right;
            while(c->left != NULL)
                c = c->left;
            return c;
        } else {
            TreeLinkNode* p = pNode->next;
            if(p == NULL) 
                return NULL;
            else if(p->right == pNode) {
                TreeLinkNode* g = p->next;
                while(g != NULL && p == g->right) {
                    p = g;
                    g = g->next;
                }
                if(g == NULL) return NULL;
                if(p == g->left) return g;
            } else if(p->left == pNode) 
                return p;
        }
        return NULL;
    }
};