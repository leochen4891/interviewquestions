__author__ = 'Lei Chen'

class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        return int("{0:032b}".format(n)[::-1],2)

s = Solution()

print(s.reverseBits(43261596), "=", "964176192")