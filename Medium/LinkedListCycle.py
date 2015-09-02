__author__ = 'Lei Chen'
'''
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
'''
from ListNode import ListNode
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# the idea is to go along the link and reverse the link after passing
# if there is a loop, it will reach the head eventually
class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # size 0 and 1
        if not head or head.next == None: return False
        if head.next == head: return True

        # size 2
        second = head.next
        if second.next == head or second.next ==

