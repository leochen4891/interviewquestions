__author__ = 'Lei Chen'
'''
Given an array of integers and an integer k, find out whether there are two
distinct indices i and j in the array such that nums[i] = nums[j] and the
difference between i and j is at most k.
'''
import math
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        value_index = {}
        for i,v in enumerate(nums):
            if not v in value_index:
                value_index[v] = i
            else:
                prev = value_index[v]
                if i - prev <= k : return True
                value_index[v] = i

        return False

s = Solution()
input = list(range(1,101))
input.append(1)

print(s.containsNearbyDuplicate(input, 100))

