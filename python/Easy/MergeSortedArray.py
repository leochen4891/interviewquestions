__author__ = 'Lei Chen'
'''
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
additional elements from nums2. The number of elements initialized in nums1 and nums2 are m
and n respectively.
'''

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        # move nums1 to the back to make some space for merging
        for i in range(m):
            nums1[n+m-1-i] = nums1[m-1-i]

        count = 0
        cur1 = 0
        cur2 = 0

        while cur1 < m and cur2 < n:
            if nums1[n+cur1] <= nums2[cur2]:
                nums1[count] = nums1[n+cur1]
                cur1+=1
            else:
                nums1[count] = nums2[cur2]
                cur2+=1
            count+=1

        if cur1 < m:
            nums1[count:] = nums1[n+cur1:]
        if cur2 < n:
            nums1[count:] = nums2[cur2:]


s = Solution()

nums1=[]
nums2 = []

print(nums1)
s.merge(nums1, 0, nums2, 0)
print(nums1)