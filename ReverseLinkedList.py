__author__ = 'Lei Chen'

from ListNode import ListNode

n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)

n1.val = 1
n2.val = 2
n3.val = 3
n4.val = 4
n5.val = 5

n1.next = n2
# n2.next = n3
# n3.next = n4
# n4.next = n5

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def reverseList(self, head):
        prev, cur = None, head

        while cur != None:
            next = cur.next
            cur.next = prev
            prev, cur = cur, next

        return prev



s = Solution()

s.reverseList(n1).printChain()