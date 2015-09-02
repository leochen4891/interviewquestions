__author__ = 'Lei Chen'

'''
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ? k ? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth
smallest frequently? How would you optimize the kthSmallest routine?
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from TreeNode import TreeNode
from collections import deque
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """

        nodes = deque()
        self.preOrderTraversal(root, nodes)
        for n in nodes:
            print(n.val)
        return nodes[len(nodes)-k].val


    def preOrderTraversal(self,root, dq):
        if not root: return
        self.preOrderTraversal(root.left, dq)
        dq.appendleft(root)
        self.preOrderTraversal(root.right, dq)

s = Solution()
nodes = TreeNode.fromArray([1,None,2])

print(s.kthSmallest(nodes[0], 1))
