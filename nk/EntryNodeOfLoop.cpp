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
    ListNode* EntryNodeOfLoop(ListNode* pHead)
    {
        ListNode* p1 = pHead->next;
        ListNode* p2 = p1 == NULL ? NULL : p1->next;
        while(p1 != p2) {
            p1 = p1 == NULL ? NULL : p1->next;
            p2 = (p2 == NULL || p2->next == NULL) ? NULL : p2->next->next;
        }
        if(p1 == NULL && p2 == NULL) 
            return NULL;
        p2 = pHead;
        while(p1 != p2) {
            p1 = p1->next;
            p2 = p2->next;
        }
        return p1;
    }
};