__author__ = 'Lei Chen'
'''
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that
occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
'''

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s or len(s) <= 10: return []
        allSubStrings = [s[i:i+10] for i in range(0, len(s)-9)]
        existing = set()
        ret = set()
        for str in allSubStrings:
            if str in existing: ret.add(str)
            else: existing.add(str)
        return list(ret)

s = Solution()

input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
print(s.findRepeatedDnaSequences(input))