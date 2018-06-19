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
        System.out.println(l1.val);
        if (l1 == null || l2 == null){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        //用head.next作为开始主要是因为方便赋值
        System.out.println(pointer.val);
        int sum = 0;
        int carry =0;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            pointer = pointer.next;
        }
        
        while(l1 != null){
            sum = l1.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            pointer = pointer.next;
        }
        
        while(l2 != null){
            sum = l2.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2.next;
            pointer = pointer.next;
        }
        if(carry != 0){
            pointer.next = new ListNode(carry);
        }
        
        
        return head.next;
    }
}