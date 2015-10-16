__author__ = 'Lei Chen'
'''
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
'''
class Solution(object):
    def threeSum(self, nums):
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums)-1
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if sum < 0:
                    l +=1
                elif sum > 0:
                    r -= 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l+1]:
                        l += 1
                    while l < r and nums[r] == nums[r-1]:
                        r -= 1
                    l += 1; r -= 1
        return res

    def threeSum2(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        size = len(nums)
        numsset = set(nums)
        targetNums = dict()
        for i in range(size):
            for j in range(i+1,size):
                sum = -(nums[i]+nums[j])
                if not sum in numsset: continue
                if sum in targetNums:
                    targetNums[sum].append([i,j])
                else:
                    targetNums[sum] = [[i,j]]

        ret = set()
        for i, n in enumerate(nums):
            if n in targetNums:
                for complist in targetNums[n]:
                    if i <= complist[-1]: continue
                    ret.add(tuple([nums[complist[0]],nums[complist[1]], nums[i]]))

        return [list(t) for t in ret]


s = Solution()
nums = [-2,0,2]
nums = [-1, 0, 1, 2, -1, -4]
print(s.threeSum(nums))
