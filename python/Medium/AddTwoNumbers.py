__author__ = 'Lei Chen'
'''
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
'''
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from ListNode import ListNode

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        head = None;
        prev = None;
        while l1 or l2 or carry:
            n1 = l1.val if l1 else 0
            n2 = l2.val if l2 else 0
            carry, num = divmod(n1+n2+carry, 10)
            node = ListNode(num)
            if not head: head = node
            if not prev: prev = node
            else:
                prev.next = node
                prev = node
            if l1: l1 = l1.next
            if l2: l2 = l2.next

        return head



head1 = ListNode.fromArray([5])
head2 = ListNode.fromArray([5])
s = Solution()
s.addTwoNumbers(head1, head2).printChain()