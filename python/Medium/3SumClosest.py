__author__ = 'Lei Chen'
'''
Given an array S of n integers, find three integers in S such that the sum
is closest to a given number, target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
'''
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        size = len(nums)
        if size < 3: return None
        closest = None
        # print(nums)
        for i in range(size-2):

            l = i+1
            r = size-1
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if sum == target: return sum
                if sum < target: l += 1
                else: r -= 1
                if (None == closest) or (abs(sum - target) < abs(closest - target)):
                    closest = sum

        return closest


s = Solution()
nums = [-3,0,1,2]
target = 1
print(s.threeSumClosest(nums, target))