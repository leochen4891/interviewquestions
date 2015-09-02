__author__ = 'Lei Chen'
'''
Given an integer array of size n, find all elements that appear more than ? n/3 ? times. The algorithm should run in linear time and in O(1) space.
'''

# possibly two elements can appear more than n/3 times
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        a, b, cnta, cntb = 0,0,0,0

        for n in nums:
            if cnta == 0 or a == n:
                cnta += 1
                a = n
            elif cntb == 0 or b == n:
                cntb += 1
                b = n
            else:
                cnta -= 1
                cntb -= 1

        cnta, cntb = 0,0

        for n in nums:
            if n == a: cnta += 1
            if n == b: cntb += 1

        ret = set()
        if cnta > len(nums)//3: ret.add(a)
        if cntb > len(nums)//3: ret.add(b)

        return list(ret)

s = Solution()
nums = [3,4,1,1,1,2,2,2]
print(s.majorityElement(nums))
