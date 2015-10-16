__author__ = 'Lei Chen'
'''
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
'''
import TreeNode


class Solution(object):
    def levelOrder(self, root):
        levels = list()
        stack = list()
        if not root: return levels
        stack.append((root, 0))
        while stack:
            node,depth = stack.pop()
            if depth >= len(levels):
                levels.append(list())
            levels[depth].insert(0,node)

            if node.left:stack.append((node.left, depth+1))
            if node.right:stack.append((node.right, depth+1))
        return levels.reverse()


    def levelOrder1(self, root):
        q = []
        r = []
        if not root:
            return r
        q.append((root,0))
        while q:
            node,level = q.pop(0)
            if len(r) == level:
                r.append([node.val])
            else:
                r[level].append(node.val)
            if node.left:
                q.append((node.left,level+1))
            if node.right:
                q.append((node.right,level+1))
        return r

s = Solution()
root = TreeNode.TreeNode.fromArray([1])
result = s.levelOrder(root)
result1 = s.levelOrder1(root)

for l in result1:
    for n in l:
        print(n, end=' ')
    print()
