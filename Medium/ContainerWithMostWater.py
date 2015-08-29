__author__ = 'Lei Chen'
'''
Given n non-negative integers a1, a2, ..., an, where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.
Note: You may not slant the container.
'''

class Solution(object):
    def maxArea(self, heights):
        """
        :type height: List[int]
        :rtype: int
        """
        if not heights or len(heights) <= 1: return 0
        size = len(heights)
        left, right = 0, size-1
        maxArea = (right - left) * min(heights[left], heights[right])

        while left < right:
            if heights[left] <= heights[right]:
                nextLeft = left+1
                while nextLeft < right and heights[nextLeft] < heights[left]:
                    nextLeft+=1
                left = nextLeft
                # print('left=', heights[left])
            else :
                nextRight = right-1
                while nextRight > left and heights[nextRight] < heights[right]:
                    nextRight-=1
                right = nextRight
                # print('right=', heights[right])

            curArea = (right - left) * min(heights[left], heights[right])
            maxArea = max(maxArea, curArea)

        return maxArea


s = Solution()
heights = [1,2,4,3]
print(s.maxArea(heights))