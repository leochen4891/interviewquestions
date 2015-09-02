__author__ = 'Lei Chen'
'''
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110
11010
11000
00000
Answer: 1

Example 2:
11000
11000
00100
00011
Answer: 3
'''
class Solution(object):
    def numIslands(self, gridStr):
        """
        :type grid: List[List[str]]
        :rtype: int
        """


        if not gridStr or len(gridStr) < 1 or len(gridStr[0]) < 1: return 0
        numRows = len(gridStr)
        numCols = len(gridStr[0])

        grid = []
        for row in range(numRows):
            newRow = []
            for col in range(numCols):
                newRow.append(int(gridStr[row][col]))
            grid.append(newRow)


        print(grid)

        numIslands = 0

        for row in range(numRows):
            for col in range(numCols):
                if grid[row][col] == 1:
                    numIslands +=1
                    self.doBFS(row,col,numRows, numCols, grid, 1 + numIslands)

        return numIslands


    def doBFS(self, row, col, numRows, numCols, grid, islandIndex):
        if grid[row][col] > 1: return
        grid[row][col] = islandIndex;
        if col > 0 and grid[row][col-1] == 1: self.doBFS(row, col-1,numRows,numCols,grid,islandIndex)
        if row > 0 and grid[row-1][col] == 1: self.doBFS(row-1, col,numRows,numCols,grid,islandIndex)
        if col < numCols-1 and grid[row][col+1] == 1: self.doBFS(row, col+1,numRows,numCols,grid,islandIndex)
        if row < numRows-1 and grid[row+1][col] == 1: self.doBFS(row+1, col,numRows,numCols,grid,islandIndex)

    def numIslands1(self, grid):
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))


grid = ['100',
        '000',
        '001']
s = Solution()
print(s.numIslands1(grid))