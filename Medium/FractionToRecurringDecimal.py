__author__ = 'Lei Chen'

'''
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
'''

class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        neg = False
        if numerator * denominator < 0: neg = True
        numerator = abs(numerator)
        denominator = abs(denominator)

        # integer part
        i, n = divmod(numerator, denominator)

        integer = str(i)

        frac = ''
        depth = 0
        repeatStart = -1
        repeats = dict()

        while n > 0:
            repeats[n] = depth
            i, n = divmod(n*10, denominator)
            frac += str(i)
            if n in repeats:
                repeatStart = repeats[n]
                frac = frac[:repeatStart] + '(' + frac[repeatStart:] + ')'
                break

            depth +=1

        if neg: integer = '-' + integer

        return integer if len(frac) == 0 else integer + '.' + frac

s = Solution()
print(s.fractionToDecimal(1,2))
print(s.fractionToDecimal(2,1))
print(s.fractionToDecimal(2,3))
print(s.fractionToDecimal(1,6))
print(s.fractionToDecimal(-50,8))





