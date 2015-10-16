__author__ = 'Lei Chen'
'''
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
'''
class Solution(object):
    def removeZeros(self, nums):
        if not nums or len(nums) < 1: return None
        if len(nums) == 1: return nums[0]
        zeros = [i for i,v in enumerate(nums) if v == 0]
        if not zeros: return self.removeNegs(nums)
        high = self.removeNegs(nums[:zeros[0]])
        for i in range(len(zeros)):
            segStart = zeros[i] + 1
            segStop = zeros[i+1] if i < len(zeros)-1 else len(nums)
            prod = self.removeNegs(nums[segStart:segStop])
            if (not high and prod) or (high and prod and prod > high):
                high = prod
        return max(high, 0) if high else 0


    def removeNegs(self, nums):
        # count the negatives
        if not nums or len(nums) < 1: return None
        if len(nums) == 1: return nums[0]
        negs = [i for i,v in enumerate(nums) if v < 0]
        if len(negs)%2 == 0: return self.productOfAllAbs(nums)
        if len(negs) == 1:
            l = self.productOfAllAbs(nums[:negs[0]])
            r = self.productOfAllAbs(nums[negs[0]+1:])
            return max(l,r) if l or r else None
        # at least 3 negs, find the leftmost and right most negs
        return max(self.productOfAllAbs(nums[negs[0]+1:]), self.productOfAllAbs(nums[:negs[-1]]))

    def productOfAllAbs(self, nums):
        if not nums or len(nums) <= 0: return 0
        prod = 1
        for n in nums:
            prod *= abs(n)
        return prod

    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.removeZeros(nums)



s = Solution()



numss = [[], [0], [2], [0, 2], [-2], [2,-2], [-2,2], [2,2], [-2,-2], [2,-2,2],
        [-2,2,-2], [1,2,3,-4,2,2,2], [1,-2,3,-4,2], [2,-2,3,-2,4,-2,5]]

for nums in numss:
    print(nums, ':', s.maxProduct(nums))

nums = [0,2]
print(nums, ':', s.removeZeros(nums))
