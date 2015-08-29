__author__ = 'Lei Chen'

class Solution:
    # @param {integer} numRows
    # @return {integer[][]}
    def generate(self, numRows):
        if numRows <= 0:
            return []
        if numRows == 1:
            return [1]

        triangle = [[1]]
        for row in range(2, numRows+1, 1):
            # print("row=", row)
            newRow = []
            for i in range(0, row, 1):
                # print("i=", i)
                if i == 0 or i == row - 1:
                    newRow.append(1)
                else:
                    newRow.append(triangle[row-2][i-1] + triangle[row-2][i])
                # print("newrow=", newRow)

            triangle.append(newRow)
            # print("triangle =", triangle)

        return triangle

s = Solution()

print(s.generate(4))

'''
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
'''