/**
 * Defition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        int num = 0;
		ListNode p = head;
		while (p != null) {
			num++;
			p = p.next;
		}
		int[] tmp = new int[num];
		p = head;
		int j = tmp.length - 1;
		while (p != null && j >= 0) {
			tmp[j] = p.val;
			p = p.next;
			j--;
		}
		p = head;
		int i = 0;
		while(p != null){
			p.val = tmp[i];
			p = p.next;
			i++;
		}
		return head;
    }
}
