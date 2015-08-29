__author__ = 'Lei Chen'
# Definition for a binary tree node.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    @staticmethod
    def fromArray(array):
        if not array or len(array) <= 0: return None

        nodes = list()
        for v in array:
            if v != None:
                nodes.append(TreeNode(v))
            else:
                nodes.append(None)

        size = len(array)
        for i in range(size):
            left = i*2+1
            right = i*2+2
            # print('i=', i, ', left=', left, ', right=', right)
            if left < size: nodes[i].left = nodes[left]
            if right < size: nodes[i].right = nodes[right]

        return nodes

    def inOrderTraversal(self, ret):
        if not self: return
        ret.append(self)
        if self.left: self.left.inOrderTraversal(ret)
        if self.right: self.right.inOrderTraversal(ret)
