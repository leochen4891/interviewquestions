__author__ = 'Lei Chen'

'''
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
'''

# need a bit counter that resets to 0 when count to 3
# the counter needs 2 bits, the n is the incoming bit, b1' and b0' are the result
# 00 -> 01 -> 10 -> 00

# b1    b0    n    b1'  b0'
#  0     0    0    0     0
#  0     1    0    0     1
#  1     0    0    1     0
#  0     0    1    0     1
#  0     1    1    1     0
#  1     0    1    0     0

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        b1 = 0
        b0 = 0
        for n in nums:
            # it is tricky to come up with a equation to get b0' and b1'
            b0 = (b0 ^ n) & (~b1)
            b1 = (b1 ^ n) & (~b0)
        return b0 | b1


    def singleNumber1(self, nums):
        a= set(nums)
        a = sum(a)*3 -sum(nums)
        a = a/2
        return a

s = Solution()
nums = [1,1,1,2,2,2,3,3]
print(s.singleNumber(nums))