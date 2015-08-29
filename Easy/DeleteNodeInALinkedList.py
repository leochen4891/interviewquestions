__author__ = 'Lei Chen'


class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution:
    # @param {ListNode} node
    # @return {void} Do not return anything, modify node in-place instead.
    def deleteNode(self, node):
        while None != node.next:
            node.val = node.next.val
            prev = node
            node = node.next
        prev.next = None

n0 = ListNode(0)
n1 = ListNode(1)
n0.next=n1

s = Solution()
s.deleteNode(n0)

print(n0.val)