__author__ = 'Lei Chen'


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def majorityElement(self, nums):
        counter = dict()
        for num in nums:
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1

        for num in counter.keys():
            if counter[num] > (len(nums) / 2):
                return num

        return


s = Solution()
arr = [1]
print(s.majorityElement(arr))
