__author__ = 'Lei Chen'

'''
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
'''

from TreeNode import TreeNode
from collections import deque

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.nodes = deque()
        self.preOrderTraversal(root, self.nodes)

    def preOrderTraversal(self,root, dq):
        if not root: return
        self.preOrderTraversal(root.left, dq)
        dq.appendleft(root)
        self.preOrderTraversal(root.right, dq)


    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.nodes) > 0

    def next(self):
        """
        :rtype: int
        """
        return self.nodes.pop().val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())

nodes = TreeNode.fromArray([4,2,6,1,3,5,7])

v = BSTIterator(nodes[0])

while v.hasNext():
    n = v.next()
    print(n)

