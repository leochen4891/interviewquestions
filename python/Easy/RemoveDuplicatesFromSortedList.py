__author__ = 'Lei Chen'
'''
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
'''

from ListNode import ListNode

class Solution(object):
    def deleteDuplicates(self, head):
        cur = head

        while cur :
            next = cur.next
            while next and cur.val == next.val:
                next = next.next
            cur.next = next
            cur = next

        return head


input = ListNode.fromArray([1])

s = Solution()
ret = s.deleteDuplicates(input)
ret.printChain()
