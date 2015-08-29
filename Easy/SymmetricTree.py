__author__ = 'Lei Chen'

import TreeNode

'''
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
'''

class Solution(object):
    def isSymmetric(self, root):
        if not root: return True
        self.switchLeftRight(root.right)
        return self.isIdentical(root.left, root.right)

    def isIdentical(self, r1, r2):
        if not r1 and not r2: return True
        if (not r1 and r2) or (not r2 and r1) or (r1.val != r2.val): return False
        return self.isIdentical(r1.left, r2.left) and self.isIdentical(r1.right, r2.right)

    def switchLeftRight(self,root):
        if not root: return
        root.left, root.right = root.right, root.left
        self.switchLeftRight(root.left)
        self.switchLeftRight(root.right)

s = Solution()

root1 = TreeNode.TreeNode.fromArray([1,2,2,3,4,4,3])
root2 = TreeNode.TreeNode.fromArray([1,2,2,None, 3, None, 3])
root3 = TreeNode.TreeNode(1)
print(s.isSymmetric(root1))
print(s.isSymmetric(root2))
print(s.isSymmetric(root3))


