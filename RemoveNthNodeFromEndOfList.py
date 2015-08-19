__author__ = 'Lei Chen'
'''
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import ListNode

class Solution:
    # @param {ListNode} head
    # @param {integer} n
    # @return {ListNode}
    def removeNthFromEnd(self, head, n):
        if head == None: return None
        if head.next == None and n == 1: return None

        dummyHead = ListNode(-1)
        dummyHead.next = head
        prev = dummyHead;
        cur = head;

        while n > 0 and cur != None:
            cur = cur.next
            n -= 1

        if n > 0: return head

        while cur != None:
            prev = prev.next
            cur = cur.next

        prev.next = prev.next.next

        return dummyHead.next

n1 = ListNode.ListNode(1)
n2 = ListNode.ListNode(2)
n3 = ListNode.ListNode(3)
n4 = ListNode.ListNode(4)
n1.next = n2
n2.next = n3
n3.next = n4

s = Solution()
s.removeNthFromEnd(n1, 0).printChain()