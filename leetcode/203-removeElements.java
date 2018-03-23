/**Defition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while(cur != null){
            if(cur.val == val){
                if(cur == head){
                    head = head.next;
                    pre = null;
                    cur = head;
                } else{
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
