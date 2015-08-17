__author__ = 'Lei Chen'
'''
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint
stopping you from robbing each of them is that adjacent houses have
security system connected and it will automatically contact the police
 if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of
money of each house, determine the maximum amount of money you can
rob tonight without alerting the police.
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        if None == nums or len(nums) <= 0:
            return 0

        include = [0]
        exclude = [0]

        for i, v in enumerate(nums):
            include.append(exclude[i] + v)
            exclude.append(max(include[i], exclude[i]))
            print(include)
            print(exclude)
            print()

        return max(include.pop(), exclude.pop())

s = Solution()
print(s.rob([1,2,1,3,2,1]))



