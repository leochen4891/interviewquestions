__author__ = 'Lei Chen'

import collections
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {void} Do not return anything, modify nums in-place instead.
    def rotate1(self, nums, k):
        k %= len(nums)
        self.reverse(nums, 0, len(nums)-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums)-1)

    def reverse(self, nums, l, r):
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1

    def rotate2(self, nums, k):
        k %= len(nums)
        for _ in range(k):
            nums.insert(0, nums.pop())

    # O(n) space
    def rotate(self, nums, k):
        deque = collections.deque(nums)
        k %= len(nums)
        for _ in range(k):
            deque.appendleft(deque.pop())
        nums[:] = list(deque)

s = Solution()

nums = [1,2,3]
s.rotate(nums,2)
print(nums)
