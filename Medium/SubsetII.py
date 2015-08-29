__author__ = 'Lei Chen'

'''
Given a collection of integers that might contain duplicates, nums, return all possible subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
'''

class Solution(object):
    def subsetsWithDup(self, nums):
        nums = sorted(nums)
        powersets = [()]
        for n in nums:
            for subset in powersets:
                powersets = powersets + [subset + (n,)]

        return [list(t) for t in set(tuple(x) for x in powersets)]


s = Solution()
input = [1,2,2]

print(s.subsetsWithDup(input))