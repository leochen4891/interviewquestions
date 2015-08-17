import re

class Solution:
    def myfunc(self, s):

        result = ""

        for w in s[::-1].split(" "):
            result += (w[::-1] + " ")
        return result[:len(result)-1]


str1 = "What a nice day today"

s = Solution()
print(str1)
print(s.myfunc(str1))