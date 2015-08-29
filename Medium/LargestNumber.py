__author__ = 'Lei Chen'
'''
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
'''

class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        ret = ''
        units = [Solution.Unit(str(n)) for n in nums]
        for u in sorted(units, reverse=True): ret += str(u)
        if ret == '0' * len(ret): return '0'
        return ret

    class Unit :
        def __init__(self,val):
            self.val = val

        def __lt__(self, other):
            minlen = min(len(self.val), len(other.val))
            if self.val[:minlen] != other.val[:minlen]: return self.val < other.val
            return  self.val + other.val < other.val + self.val

        def __str__(self):
            return str(self.val)



s = Solution()
nums = [0,0,0,1]
print(s.largestNumber(nums))
