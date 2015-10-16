__author__ = 'Lei Chen'

'''
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
'''

class Solution(object):
    def plusOne(self, digits):

        carry = True
        for i in range(len(digits)-1, -1, -1):
            if digits[i] == 9 and carry == True:
                digits[i] = 0
                continue
            else:
                digits[i] += 1
                carry = False
                break

        if carry == True:
            digits.insert(0,1)

s = Solution()

digits = [0]
print(digits)
s.plusOne(digits)
print(digits)



