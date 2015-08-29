__author__ = 'Lei Chen'

# board: List[List[str]]
class Solution(object):
    def isValidSudoku(self, board):
        for row in range(9):
            if not self.no_conflict(board[row]) : return False

        for col in range(9):
            column = list()
            for row in range(9):
                column.append(board[row][col])
            if not self.no_conflict(column): return False

        for topRow, leftCol in self.all3x3():
            square = list()
            for row, col in self.each3x3(topRow,leftCol):
                square.append(board[row][col])
            if not self.no_conflict(square): return False

        return True


    def all3x3(self):
        for row in range(0,9,3):
            for col in range(0,9,3):
                yield row, col


    # row, col is the left top corner, generate 3x3
    def each3x3(self, topRow, leftCol):
        for row in range(topRow, topRow+3):
            for col in range(leftCol, leftCol+3):
                yield row, col


    def no_conflict(self, nums):
        checkarr = [0] * 9
        for c in nums:
            if c == '.': continue
            num = int(c)-1
            if checkarr[num] != 0: return False
            checkarr[num] = 1
        return True

s = Solution()

input = [".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
print(s.isValidSudoku(input))