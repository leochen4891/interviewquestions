__author__ = 'Lei Chen'
'''
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
'''
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0: return None
        if len(nums) <= 2: return min(nums[0], nums[-1])
        if nums[0] < nums[-1]: return nums[0]
        return self.helper(nums, 0, len(nums)-1)

    def helper(self, nums, l, r):
        if l >= r: return None
        m = (l+r)//2
        if nums[m] > nums[m+1]: return nums[m+1]
        if nums[l] > nums[m]: return self.helper(nums, l, m)
        return self.helper(nums,m+1, r)




s = Solution()
numss = [[], [1], [1,2], [1,2,3,4], [4,1,2,3],[3,4,1,2], [2,3,4,1]]

for nums in numss:
    print(nums, ':', s.findMin(nums))