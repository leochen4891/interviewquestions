__author__ = 'Lei Chen'
class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        if strs == '' or len(strs) == 0: return None
        prefix = ''
        for i, c in enumerate(strs[0]):
            for str in strs[1:]:
                if i >= len(str): return prefix
                if str[i] != c: return prefix
            prefix += c
        return prefix

s = Solution()
print(s.longestCommonPrefix(["aa","a"]))