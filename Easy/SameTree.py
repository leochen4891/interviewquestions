__author__ = 'Lei Chen'

class Solution(object):
    def isSameTree(self, r1, r2):
        return True if (not r1 and not r2) else (False if (not r1 and r2) or (not r2 and r1) or (r1.val != r2.val) else self.isSameTree(r1.left, r2.left) and self.isSameTree(r1.right, r2.right))

