__author__ = 'Lei Chen'

class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {void} Do not return anything, modify nums in-place instead.
 def rotate(self, nums, k):
    k %= len(nums)
    for i in range(k):
        print(nums)
        nums.insert(0, nums.pop())



        # size = len(nums)
        # k = k % size
        # buf = [None]*size
        # for i in range(size):
        #     buf[(i+k)%size]=nums[i]
        # for i in range(size):
        #     nums[i] = buf[i]

s = Solution()

nums = [1,2,3]
s.rotate(nums,2)
print(nums)
