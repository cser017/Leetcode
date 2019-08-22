/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode c1 = l1, c2 = l2, cur = dummyHead;
        int carry = 0;
        while(c1 != null || c2 != null){
            int sum = ((c1 != null)? c1.val : 0) + ((c2 != null)? c2.val : 0) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(c1 != null){
                c1 = c1.next;
            }
            if(c2 != null){
                c2 = c2.next;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}