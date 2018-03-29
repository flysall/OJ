/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if(pListHead == NULL || k <= 0)
            return NULL;
        ListNode* p = pListHead;
        ListNode* q = pListHead;
        unsigned int cur = 1;
        while(cur < k && p != NULL) {
            p = p->next;
            cur++;
        }
        if(p == NULL) return NULL;
        while(p->next != NULL) {
            p = p->next;
            q = q->next;
        }
        return q;
    }
};