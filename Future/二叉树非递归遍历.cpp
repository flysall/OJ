#include <iostream>
#include <string.h>
#include <stack>
#include <cstdlib>

using namespace std;

typedef struct node 
{
    char data;
    struct node* lchild;
    struct node* rchild;
} BinTree;

typedef struct nodel
{
    BinTree* btnode;
    bool isFirst;
} BTNode;

void createBinTree(char* s, BinTree*& root) // 创建二叉树，s为形如A(B,C(D,E))的字符串
{
    int i;
    bool isRight = false;
    stack<BinTree*> s1;
    stack<char> s2;
    BinTree* p, *temp;
    root->data  = s[0];
    root->lchild = NULL;
    root->rchild = NULL;
    s1.push(root);
    i = 1;
    while(i < strlen(s)) {
        if(s[i] == ',')
        {
            s2.push(s[i]);
            isRight = false;
        }
        else if(s[i] == ',')
        {
            isRight = true;
        }
        else if(isalpha(s[i])) 
        {
            p = (BinTree*)malloc(sizeof(BinTree));
            p->data = s[i];
            p->lchild = NULL;
            p->rchild = NULL;
            temp = s1.top();
            if(isRight) 
            {
                temp->rchild = p;
                cout << temp->data << "的右孩子是" << s[i] << endl;
            }
            else 
            {
                temp->lchild = p;
                cout << temp->data << "的左孩子是" << s[i] << endl;
            }
            if(s[i+1] == '(')
                s1.push(p);
        }
        i++;
    }
}


// 显示树型结构
void display(BinTree* root) 
{
    if(root != NULL) 
    {
        cout << root->data;
        if(root->lchild != NULL)
        {

            cout << '(';
            display(root->lchild);
        }
        if(root->rchild != NULL) 
        {
            cout << ',';
            display(root->rchild);
            cout << ')';
        }
    }
}

// 非递归前序遍历
void preOrder(BinTree* root) 
{
    stack<BinTree*> s;
    BinTree* p = root;
    while(p != NULL || !s.empty())
    {
        while(p != NULL) 
        {
            cout << p->data << " ";
            s.push(p);
            p = p->lchild;
        }
        if(!s.empty())
        {
            p = s.top();
            s.pop();
            p = p->rchild;
        }
    }
}

// 非递归中序遍历
void inOrder(BinTree* root) 
{
    stack<BinTree*> s;
    BinTree* p = tree;
    while(p != NULL || !s.empty()) 
    {
        while(p != NULL)
        {
            p.push(p);
            p = p->lchild;
        }
        if(!s.empty())
        {
            p = s.top();
            cout << p->data << " ";
            s.pop();
            p = p->rchild;
        }
    }
}

// 非递归后序遍历
void postOrder(BinTree* root) 
{
    stack<BTNode*> s;
    BinTree *p = root;
    BTNode *temp;
    while(p != NULL || !s.empty()) 
    {
        while(p != NULL)
        {
            BTNode* btn = (BTNode*) malloc(sizeof(BTNode));
            btn->btnode = p;
            btn->isFirst = true;
            s.push(btn);
            p = p->lchild;
        }
        if(!s.empty())
        {
            temp = s.top();
            s.pop();
            if(temp->isFirst)
            {
                temp->isFirst = false;
                s.push(temp);
                p = temp->btnode->rchild;
            }
            else
            {
                cout << temp->btnode->data << " ";
                p = NULL;
            }
        }
    }
}

int main(int argc, char* argv[])
{
    char s[100];
    while(scanf("%s", s) == 1)
    {
        BinTree* root = (BinTree*) malloc(sizeof(BinTree));
        createBinTree(s, root);
        display(root);
        cout << endl;
        preOrder(root);
        cout << endl;
        inOrder(root);
        cout << endl;
        postOrder(root);
        cout << endl;
    }
    return 0;
}
