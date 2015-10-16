__author__ = 'Lei Chen'
'''
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import TreeNode


class Solution(object):
    def __init__(self):
        self.md = 1

    def maxDepth(self, root):
        if not root: return 0

        if root.left: self.reportDepth(root.left, 1)
        if root.right: self.reportDepth(root.right, 1)

        return self.md

    def reportDepth(self, root, preDepth):
        if not root.left and not root.right and preDepth+1 > self.md: self.md = preDepth+1

        if root.left: self.reportDepth(root.left, preDepth+1)
        if root.right: self.reportDepth(root.right, preDepth+1)

s = Solution()

print(s.maxDepth(TreeNode.TreeNode.fromArray([0,1,2,3,None,None])))