__author__ = 'Lei Chen'
'''
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1,3,4]
'''

from TreeNode import TreeNode
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Level order traversal, get rightmost node on each level
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        levels = list()
        self.levelOrderTraversal(root, 0, levels)
        return [level[len(level)-1] for level in levels]

    def levelOrderTraversal(self,root, depth, levels):
        if not root: return
        if depth >= len(levels): levels.append([])
        levels[depth].append(root.val)

        if root.left: self.levelOrderTraversal(root.left, depth+1, levels)
        if root.right: self.levelOrderTraversal(root.right, depth+1, levels)

head = TreeNode.fromArray([1,2,3,None,5,None,None])

s = Solution()
for n in s.rightSideView(head):
    print (n)