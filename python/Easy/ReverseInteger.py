__author__ = 'Lei Chen'
'''
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
'''

class Solution:
    # @param {integer} x
    # @return {integer}
    def reverse(self, x):
        rev = int(str(x)[::-1].replace('-',''))
        if x < 0: rev = 0-rev
        if rev > 2147483651 or rev < -2147483651 : return 0 # check overflow for 32bit int?
        return rev

s = Solution()
print(s.reverse(123))
print(s.reverse(-123))
print(s.reverse(100))
print(s.reverse(-100))
print(s.reverse(1534236469))
