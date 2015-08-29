__author__ = 'Lei Chen'
'''
Given an array of n integers where n > 1, nums, return an array output such that output[i]
is equal to the Prodsuct of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count
as extra space for the purpose of space complexity analysis.)
'''

class Solution(object):
    # O(n) and no division
    def ProdsuctExceptSelf1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        size = len(nums)
        Prods = 1
        leftProds = [nums[0]]
        rightProds = [nums[-1]]
        for i in range(1,size):
            leftProds.append(leftProds[-1]*nums[i])
            rightProds.append((rightProds[-1]*nums[size-1-i]))
        rightProds.reverse()
        # print(leftProds)
        # print(rightProds)

        ret = []
        for i in range(size):
            prod = 1
            if i > 0: prod *= leftProds[i-1]
            if i < size - 1: prod *= rightProds[i+1]
            ret.append(prod)

        # print(ret)
        return ret

    # and in constant space complexity
    # the idea is to save right products in the ret arr first and in the 2nd scan, calculate the
    # left products on the fly
    def ProdsuctExceptSelf(self, nums):
        size = len(nums)
        ret = [None]*size
        ret[size-1] = nums[size-1]
        for i in range(size-2, -1, -1):
            ret[i] = ret[i+1] * nums[i]

        leftProds = 1
        for i in range(size):
            if i > 0: leftProds *= nums[i-1]
            ret[i] = leftProds * (1 if i >= size-1 else ret[i+1])

        return ret





arr = [1,2,3,4]
s = Solution()
print(s.ProdsuctExceptSelf(arr))

