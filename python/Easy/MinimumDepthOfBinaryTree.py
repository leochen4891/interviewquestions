__author__ = 'Lei Chen'
'''
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
'''

import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def minDepth(self, root):
        if not root: return 0
        return self.helper(root,0)

    def helper(self,root, prefix):
        if not root.left and not root.right: return prefix+1

        if root.left and root.right: return min(self.helper(root.left, prefix+1), self.helper(root.right, prefix+1))
        elif root.left: return self.helper(root.left, prefix+1)

        return self.helper(root.right, prefix+1)



s = Solution()
n1 = TreeNode.TreeNode(1)
n2 = TreeNode.TreeNode(2)
n1.left = n2

print(s.minDepth(n1))
