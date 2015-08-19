__author__ = 'Lei Chen'

'''
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
'''

class Solution:
    # @param {string} haystack
    # @param {string} needle
    # @return {integer}
    def strStr(self, haystack, needle):
        haylen = len(haystack)
        neelen = len(needle)

        if len(haystack) < len(needle): return -1
        if haylen == 0 and neelen == 0: return 0

        for i in range(haylen-neelen+1):
            match = True
            for j in range(neelen):
                if haystack[i+j] != needle[j]:
                    match = False
                    break
            if match: return i

        return -1

s = Solution()

haystack = ""
needle = ""
print(s.strStr(haystack, needle))#, haystack.index(needle))