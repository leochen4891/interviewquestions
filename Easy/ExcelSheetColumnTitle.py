__author__ = 'Lei Chen'

class Solution:
    # @param {integer} n
    # @return {string}
    def convertToTitle(self, n):
        if n < 1:
            return
        alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        ret = ""
        remain = n
        while remain > 0:
            ret += alphabets[int((remain - 1) % 26)]
            remain = int((remain - 1)/26)
            print("remain", "=", remain)
        return ret[::-1]

s = Solution()
# print(s.convertToTitle(0))
print(s.convertToTitle(1))
print(s.convertToTitle(26))
print(s.convertToTitle(27))
print(s.convertToTitle(28))

