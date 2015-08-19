__author__ = 'Lei Chen'

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import ListNode

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def mergeTwoLists(self, l1, l2):
        dummyHead = ListNode.ListNode(-1)
        prev = dummyHead

        while l1 != None and l2 != None:
            if l1.val <= l2. val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next

            prev = prev.next

        prev.next = l1 if l1 != None else l2

        return dummyHead.next

s = Solution()

n1 = ListNode.ListNode(1)
n2 = ListNode.ListNode(2)
n3 = ListNode.ListNode(3)
n4 = ListNode.ListNode(4)
n5 = ListNode.ListNode(5)
n1.next = n3
n3.next = n5
n2.next = n4

s.mergeTwoLists(n1,n2).printChain()
