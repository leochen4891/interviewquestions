__author__ = 'Lei Chen'

class Solution:
    # @param n, an integer
    # @return an integer
    def hammingWeight(self, n):
        return "{0:b}".format(n).count('1')

s = Solution()

print(s.hammingWeight(11))
