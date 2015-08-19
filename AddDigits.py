__author__ = 'Lei Chen'

class Solution:
    # @param {integer} num
    # @return {integer}
    def addDigits(self, num):
        sum = num
        while sum >= 10:
            remain = sum
            tempSum = 0
            while remain > 0:
                tempSum = tempSum + remain % 10
                remain = int(remain / 10)
            sum = tempSum

        return sum


s = Solution()
print(s.addDigits(38))