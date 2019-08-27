/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Iterative
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    // Recursive
    public ListNode reverseList2(ListNode head) {    
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);  
        head.next.next = head;
        head.next = null;
        return res;
    }
}
