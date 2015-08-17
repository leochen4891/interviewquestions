__author__ = 'Lei Chen'

class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        if numRows == 1: return s

        ret = ""
        offset = 2*numRows - 2
        for row in range(numRows):
            if row == 0 or row == numRows-1: # only 1 char each section for top and bot rows
                index = row
                while index < len(s):
                    ret += s[index]
                    index += offset
            else:
                index = row
                while index < len(s):
                    ret += s[index]
                    dist = ((numRows-1) - row) * 2
                    # print("row =", row, ", index =", index, ", dist =", dist)
                    if index + dist < len(s): ret += s[index + dist]
                    index += offset

        return ret

s = Solution()
str = "123456789abcdef"

output = s.convert(str, 2)
expected = "13579bdf2468ace"
print(str, "-->", output, ", expected =" + expected, "correct =", (output == expected))

output = s.convert(str, 3)
expected = "159d2468ace37bf"
print(str, "-->", output, ", expected =" + expected, "correct =", (output == expected))

output = s.convert(str, 4)
expected = "17d268ce359bf4a"
print(str, "-->", output, ", expected =" + expected, "correct =", (output == expected))