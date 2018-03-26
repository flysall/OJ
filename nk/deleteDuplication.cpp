/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};
*/
class Solution {
public:
    ListNode* deleteDuplication(ListNode* pHead)
    {
        if(pHead == NULL) return pHead;
        ListNode* pre = NULL;
        ListNode* cur = pHead;
        ListNode* next = pHead->next;
        while(cur != NULL && next != NULL) {
            if(next->val != cur->val) {
                pre = cur;
                cur = next;
                next = next->next;
            } else {
                while(next != NULL && next->val == cur->val) 
                    next = next->next;
                if(pre !=  NULL) {
                    if(next == NULL) {
                        pre->next = NULL;
                        break;
                    }
                    pre->next = next;
                    cur = next;
                    next = next->next;
                } else {
                    pHead = next;
                    cur = pHead;
                    next = pHead->next;
                }
            }
        }
        return pHead;
    }
};