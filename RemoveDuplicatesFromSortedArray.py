__author__ = 'Lei Chen'
'''
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if nums == None: return 0;
        if len(nums) <= 1: return len(nums)

        count = 0
        prev = nums[0]

        nums.append(None)
        for num in nums[1:]:
            if prev != num:
                nums[count] = prev
                prev = num
                count += 1
        return count

s = Solution()

input = [3,3,4,4]
print(s.removeDuplicates(input))
print(input)