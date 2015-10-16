__author__ = 'Lei Chen'
'''
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
'''

class Solution(object):
    def searchMatrix(self, matrix, target):
        nRow = len(matrix)
        nCol = len(matrix[0])

        row = 0
        col = nCol - 1
        while row < nRow and col >= 0:
            if matrix[row][col] == target: return True
            if target < matrix[row][col]:
                col -= 1
            if target > matrix[row][col]:
                row += 1
        return False

    def searchMatrix1(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        nRow = len(matrix)
        nCol = len(matrix[0])

        row = nRow - 1
        col = 0
        while row >= 0 and col < nCol:
            while row >= 0 and matrix[row][col] > target:
                row -= 1
                continue
            if row < 0: break

            while col < nCol and matrix[row][col] < target:
                col += 1
                continue
            if col >= nCol: break

            if matrix[row][col] == target: return True

        return False

matrix = \
[
  [10, 20, 30, 40, 50],
  [12, 22, 32, 42, 52],
  [14, 24, 34, 44, 54],
  [16, 26, 36, 46, 56],
  [18, 28, 38, 48, 58]
]
s = Solution()
# i = 52
# print(i, ':', s.searchMatrix(matrix,i))
for i in range (60):
    print(i, ':', s.searchMatrix(matrix,i))