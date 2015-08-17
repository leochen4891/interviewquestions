__author__ = 'Lei Chen'

import TreeNode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @param {TreeNode} p
    # @param {TreeNode} q
    # @return {TreeNode}
    def lowestCommonAncestor(self, root, p, q):
        if root == p: return p
        if root == q: return q

        if p < root and q < root:
            return self.lowestCommonAncestor(root.left, p, q)
        if p > root and q > root:
            return self.lowestCommonAncestor(root.right, p, q)

        return root


