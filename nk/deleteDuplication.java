/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return pHead;
        if(pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while(pNode != null && pNode.val == pHead.val) 
                pNode = pNode.next;
            return deleteDuplication(pNode);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}