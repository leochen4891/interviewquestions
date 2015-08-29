__author__ = 'Lei Chen'
'''
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
'''
import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isBalanced(self, root):
        if not root: return True
        leftDepth = self.getDepth(root.left, 1)
        rightDepth = self.getDepth(root.right,1)

        if abs(leftDepth - rightDepth) > 1: return False

        if not self.isBalanced(root.left): return False
        if not self.isBalanced(root.right): return False

        return True

    def getDepth(self, root, preDepth):
        if not root:
            return preDepth
        elif not root.left and not root.right:
            return preDepth+1

        leftDepth = self.getDepth(root.left,preDepth+1)
        rightDepth = self.getDepth(root.right,preDepth+1)

        return max(leftDepth, rightDepth)

s = Solution()

n1 = TreeNode.TreeNode(1)
n2 = TreeNode.TreeNode(2)
n3 = TreeNode.TreeNode(3)

n3.left = n1
n1.right = n2

print(s.isBalanced(n3))