/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            ListNode l1 = head.next;
            ListNode l2 = head.next.next;
            
            head.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            //head->l1->l2->...
            //head->l2->l1->...
            
            head = l1;
        }
        return dummy.next;
    }
}