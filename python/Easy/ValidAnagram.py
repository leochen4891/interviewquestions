__author__ = 'Lei Chen'

class Solution:
    # @param {string} s
    # @param {string} t
    # @return {boolean}
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False

        chars = dict()
        for c in s:
            # print(c)
            if c in chars:
                chars[c] += 1
            else:
                chars[c] = 1

        for c in t:
            if c not in chars:
                return False

            if chars[c] <= 0:
                return False

            chars[c] -= 1

        return True




s = Solution()
print(s.isAnagram('ab', 'a'))
