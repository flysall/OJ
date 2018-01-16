/**Defition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(cur.val == pre.val)
                pre.next = cur.next;
            else
                pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
