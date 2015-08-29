__author__ = 'Lei Chen'
'''
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
'''

class Solution(object):

    def searchMatrix(self, matrix, target):
        firstCol = [row[0] for row in matrix]
        ret, index = self.bs(firstCol, 0, len(firstCol)-1, target)
        if ret: return True
        # print(target, ', index = ', index)
        return self.bs(matrix[index], 0, len(matrix[index])-1, target)[0]

    def searchMatrix1(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        flat = [i for row in matrix for i in row ]
        print(flat)
        return self.bs(flat, 0, len(flat)-1, target)

    def bs(self, arr, l, r, target):
        if l > r : return False, r

        mid = int((l+r)/2)
        if arr[mid] == target: return True, mid
        if arr[mid] > target: return self.bs(arr, l, mid-1, target)
        return self.bs(arr,mid+1,r,target)




s = Solution()
matrix =\
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 35]
]

for i in [0,1,2,3,4,5,7,8,9,10,11,15,16,17,20,21,22,23,25,30,33,34,35,40]:
    print(i, ':', s.searchMatrix(matrix,i))
    # s.searchMatrix(matrix,i)
# arr = [1,3,5]
# print(s.bs(arr,0,2,6))