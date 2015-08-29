__author__ = 'Lei Chen'
'''
Given a set of distinct integers, nums, return all possible subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
'''
from itertools import chain
from itertools import combinations
    

class Solution(object):
    def subsets(self, nums):
        nums = sorted(nums)
        powersets = [[]]
        for n in nums:
            for subsets in powersets:
                powersets = powersets + [subsets + [n]]
        return powersets

    def subsets1(self, nums):
        nums = sorted(nums)
        powersets = []
        size = len(nums)
        for mask in range(1 << size):
            powersets += [[nums[pos] for pos in range(size) if mask & (1 << pos)]]
        return powersets

    def subsets2(self, nums):
        nums = sorted(nums)
        # nesting is in left-to-right order
        # it is equivalent to
        # for comb in (combinations(input, r) for r in range(len(input)+1)):
        #   for x in comb:
        #     ret = ret + [list(x)]
        return ([list(x) for comb in (combinations(nums, r) for r in range(len(nums)+1)) for x in comb])


s = Solution()
input = [1,2,3]
print(s.subsets(input))
print(s.subsets1(input))
print(s.subsets2(input))





