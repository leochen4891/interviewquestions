__author__ = 'Lei Chen'
import re

class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLastWord(self, s):
        if None == s: return 0
        return len(s.strip().split(" ")[-1])

s = Solution()

str = "here is a test string  "
print(str, ":", s.lengthOfLastWord(str))
