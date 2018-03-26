/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {
    public ListNode (ListNode pHead)
    {
        Set<ListNode> set = new HashSet<>();
        while(true) {
            if(pHead != null && set.add(pHead))
                pHead = pHead.next;
            else
                break;
        }
        return pHead;
    }
}