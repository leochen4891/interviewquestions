__author__ = 'Lei Chen'
'''
Given a string s and a dictionary of words dict, determine if s
can be segmented into a space-separated sequence of one or more
dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
'''


class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        if not s or len(s) == 0: return False
        candidates = [self.Candidate(word) for word in wordDict]
        i = 0
        while len(candidates) > 0 and i < len(s):
            c = s[i]
            # print('c =', c)
            candidates = [cand for cand in candidates if
                           cand.checkPos < len(cand.word) and cand.word[cand.checkPos] == c]
            breakable = False
            for cand in candidates:
                if cand.checkPos == len(cand.word) - 1:
                    breakable = True
                cand.checkPos += 1

            if i == len(s) - 1 and breakable: return True

            if breakable: candidates += self.findWordsStartsWith(wordDict, s[i + 1])

            i += 1

        return False

    def findWordsStartsWith(self, words, starts):
        return [self.Candidate(word) for word in words if word[0] == starts]

    class Candidate:
        def __init__(self, word):
            self.word = word
            self.checkPos = 0


s = Solution()

str = 'leetcodee'
dict = ["leet", "code",'codee']
print(s.wordBreak(str, dict))
