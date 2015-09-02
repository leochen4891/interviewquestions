__author__ = 'Lei Chen'
'''
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        xor = 0
        for n in nums:
            xor = xor ^ n

        # get the lowest 1
        mask = xor & (-xor) # can also be achieved by n & -n
        print('mask = ', mask)

        n1 = 0
        n2 = 0
        for n in nums:
            if mask & n:
                n1 = n1 ^ n
            else:
                n2 = n2 ^ n

        return [n1,n2]



s = Solution()
nums = [1,1,2,2,3,5]
print(s.singleNumber(nums))
