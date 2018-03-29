/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        fromTail(listNode, res);
        return res;
    }
    private void fromTail(ListNode node, ArrayList<Integer> res) {
        if(node == null)
            return;
        else {
            fromTail(node.next, res);
            res.add(node.val);
        }
    }
}