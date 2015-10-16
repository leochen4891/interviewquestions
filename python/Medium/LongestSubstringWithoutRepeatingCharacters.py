__author__ = 'Lei Chen'
'''
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1
'''

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s: return 0
        if len(s) <= 1: return len(s)

        prefixStart = 0
        prefixStop = 0
        longest = 1
        for i, c in enumerate(s[1:],start=1):
            if c not in s[prefixStart:prefixStop+1]:
                prefixStop = i
                longest = max(longest, prefixStop - prefixStart + 1)

            else:
                longest = max(longest, prefixStop - prefixStart + 1)
                index = s[prefixStart:prefixStop+1].index(c)
                prefixStart = prefixStart+index+1
                prefixStop = i

        return longest



s = Solution()
print(s.lengthOfLongestSubstring("abcabcbc"))

