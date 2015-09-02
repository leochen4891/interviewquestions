__author__ = 'Lei Chen'
'''
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
'''

class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        ret = ''
        for w in [word[::-1] for word in s[::-1].split(' ')]:
            if w == '': continue
            ret += w + ' '
        return ret.strip()


s = Solution()
str = "   a   b "#"the sky is blue"
expect = "b a"#"blue is sky the"
print(s.reverseWords(str))
