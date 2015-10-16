__author__ = 'Lei Chen'
'''
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined
between two nodes v and w as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself)."

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is
LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the
LCA definition.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from TreeNode import TreeNode
class Solution(object):
    def __init__(self):
        self.levels = list()

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        levels = []
        self.findPQ(root,p,q,0,levels)
        for i, n in enumerate(levels):
            if n: print(i, ":", n.val)
        return [node for node in levels if node][-1] if levels else None



    def findPQ(self,root, p, q, depth, levels):
        if depth >= len(levels): levels.append(None)
        if not root: return (False, False)
        hasP = False
        hasQ = False
        if root == p: hasP = True
        if root == q: hasQ = True
        leftHasP, leftHasQ = self.findPQ(root.left, p, q, depth+1, levels)
        rightHasP, rightHasQ = self.findPQ(root.right, p, q, depth+1, levels)
        pp = hasP or leftHasP or rightHasP
        qq = hasQ or leftHasQ or rightHasQ
        if pp and qq: levels[depth] = root
        return (pp,qq)

    def betterOne(self, root, p, q):
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q) for kid in (root.left, root.right))
        return root if left and right else left or right



nodes = TreeNode.fromArray([3,5,1,6,2,0,8,None,None,7,4])
# for node in nodes:
#     if node: print(node.val)

s = Solution()
n5 = nodes[1]
n1 = nodes[2]
n4 = nodes[10]

# print(s.lowestCommonAncestor(nodes[0], n5, n1).val)
print(s.lowestCommonAncestor(nodes[0], n5, n4).val)