__author__ = 'Lei Chen'

class Solution:
    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        if None == nums or len(nums) <= 0:
            return []

        ret = []
        start = nums[0]
        prev = nums[0]
        for i in range(1,len(nums)):
            num = nums[i]
            if num == prev + 1:
                prev = num
                continue

            if prev == start:
                ret.append(start)
            else:
                ret.append(str(start) + "->" + str(prev))
            start = num
            prev = num

        if prev == start:
            ret.append(str(start))
        else:
            ret.append(str(start) + "->" + str(prev))
            start = num
            prev = num
        return ret

s = Solution()

input = [1,2,3,5,7,9,10,11,12,14]

print(s.summaryRanges(input))
