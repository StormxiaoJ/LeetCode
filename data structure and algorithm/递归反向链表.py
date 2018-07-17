# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        def helper(head):
            if head.next is None:
                return (head, head)
            newH, newT = helper(head.next)
            head.next = None
            newT.next = head
            return (newH, head)
        
        if head is None:
            return None
        else:
            head, tail = helper(head)
            return head
        
        

        