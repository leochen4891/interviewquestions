__author__ = 'Lei Chen'

class Solution:
    # @param {integer} n
    # @return {boolean}
    def isPowerOfTwo(self, n):
        return (n & (n-1))==0

s = Solution()

for i in range(20):
    print("i =", i, s.isPowerOfTwo(i))
