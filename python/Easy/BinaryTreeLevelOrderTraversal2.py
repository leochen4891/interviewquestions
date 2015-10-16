__author__ = 'Lei Chen'

import TreeNode


class Solution(object):
    def levelOrderBottom(self, root):
        levels = list()
        stack = list()
        if not root: return levels
        stack.append((root, 0))
        while stack:
            node,depth = stack.pop()
            if depth >= len(levels):
                levels.append(list())
            levels[depth].insert(0,node.val)

            if node.left:stack.append((node.left, depth+1))
            if node.right:stack.append((node.right, depth+1))

        return levels[::-1]


s = Solution()
root = TreeNode.TreeNode.fromArray([1])
result = s.levelOrderBottom(root)

for l in result:
    for n in l:
        print(n, end=' ')
    print()
