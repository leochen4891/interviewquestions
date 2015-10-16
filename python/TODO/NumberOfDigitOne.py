__author__ = 'Lei Chen'

'''
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
'''

# still cannot fully understand the solution
class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n > 0:
            pass


    def bf(self, n):
        count = 0
        for i in range(1,n+1):
            for c in str(i):
                if c == '1':
                    count += 1

        return count



s = Solution()
print(s.bf(13))