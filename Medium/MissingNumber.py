__author__ = 'Lei Chen'

'''
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
For example,
Given nums = [0, 1, 3] return 2.
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
'''

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        n = len(nums)
        # since +0 == -0, +1 to all items to make them positive
        nums = [i+1 for i in nums]

        # since the index is from 0 to n-1, need a flag for n
        nFound = False

        for num in nums:
            ori = abs(num) - 1
            if ori == n : nFound = True
            else: nums[ori] = -nums[ori]

        if not nFound: return n

        for i, num in enumerate(nums):
            if num > 0: return i

        return -1






arr1 = list(range(10))
arr2 = list(range(1,11))
arr3 = list(range(0,4)) + list(range(5,11))
arr4 = [2,0]


s = Solution()
print(arr1, s.missingNumber(arr1))
print(arr2, s.missingNumber(arr2))
print(arr3, s.missingNumber(arr3))
print(arr4, s.missingNumber(arr4))

