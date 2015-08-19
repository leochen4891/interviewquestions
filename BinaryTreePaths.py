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
    # @return {string[]}
    def binaryTreePaths(self, root):
        if root == None: return []
        if root.left == None and root.right == None: return [str(root.val)]
        ret = list()

        if root.left: self.helper(root.left, str(root.val), ret)
        if root.right: self.helper(root.right, str(root.val), ret)

        return ret


    def helper(self, root, pre_list, ret):

        if root.left == None and root.right == None:
            ret.append(pre_list + "->" + str(root.val))

        if root.left: self.helper(root.left, pre_list + "->" + str(root.val), ret)
        if root.right: self.helper(root.right, pre_list + "->" + str(root.val), ret)

'''
   1
 /   \
2     3
 \
  5
'''

n1 = TreeNode.TreeNode(1)
n2 = TreeNode.TreeNode(2)
n3 = TreeNode.TreeNode(3)
n4 = TreeNode.TreeNode(4)
n5 = TreeNode.TreeNode(5)
n1.left = n2
n1.right = n3
n2.right = n5

s = Solution()
print(s.binaryTreePaths(n1))