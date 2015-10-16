__author__ = 'Lei Chen'
'''
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
Note that 1 is typically treated as an ugly number.
'''

class Solution:
    # @param {integer} num
    # @return {boolean}
    def isUgly(self, num):
        if not num: return False
        if num >= 0 and num <= 6: return True

        while num > 1:
            if num % 2 == 0:
                num /= 2
                continue
            if num % 3 == 0:
                num /= 3
                continue
            if num % 5 == 0:
                num /= 5
                continue
            break

        return num == 1

s = Solution()
i = -2147483648
print(i, ":", s.isUgly(i))