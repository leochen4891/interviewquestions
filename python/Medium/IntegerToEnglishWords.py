__author__ = 'Lei Chen'
'''
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
'''
class Solution(object):
    def units(self, u):
        return ['', " Thousand", " Million", " Billion"][u]

    def lessThan100(self,n):
        hundredTable=["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                      "Nineteen", "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five",
                      "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine", "Thirty", "Thirty One", "Thirty Two",
                      "Thirty Three", "Thirty Four", "Thirty Five", "Thirty Six", "Thirty Seven", "Thirty Eight",
                      "Thirty Nine", "Forty", "Forty One", "Forty Two", "Forty Three", "Forty Four", "Forty Five",
                      "Forty Six", "Forty Seven", "Forty Eight", "Forty Nine", "Fifty", "Fifty One", "Fifty Two",
                      "Fifty Three", "Fifty Four", "Fifty Five", "Fifty Six", "Fifty Seven", "Fifty Eight", "Fifty Nine",
                      "Sixty", "Sixty One", "Sixty Two", "Sixty Three", "Sixty Four", "Sixty Five", "Sixty Six",
                      "Sixty Seven", "Sixty Eight", "Sixty Nine", "Seventy", "Seventy One", "Seventy Two", "Seventy Three",
                      "Seventy Four", "Seventy Five", "Seventy Six", "Seventy Seven", "Seventy Eight", "Seventy Nine",
                      "Eighty", "Eighty One", "Eighty Two", "Eighty Three", "Eighty Four", "Eighty Five", "Eighty Six",
                      "Eighty Seven", "Eighty Eight", "Eighty Nine", "Ninety", "Ninety One", "Ninety Two", "Ninety Three",
                      "Ninety Four", "Ninety Five", "Ninety Six", "Ninety Seven", "Ninety Eight", "Ninety Nine"]
        return hundredTable[n%100]

    def lessThan1000(self,n):
        i, r = divmod(n, 100)
        ret = ""
        ret += "" if i <= 0 else " " + self.lessThan100(i) + " Hundred"
        ret += "" if r == 0 else " " + self.lessThan100(n)
        return ret

    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0: return "Zero"
        if num < 100: return self.lessThan1000(num).strip()
        ret = ''
        for power in range(3, -1, -1):
            i, num = divmod(num, 1000**power)
            # print(i, num)
            if i > 0:
                ret += self.lessThan1000(i) + self.units(power)
        return ret.strip()



s = Solution()
nums = [0,1,12,123,1234,12345,123456,1234567,12345678,123456789,1234567890]
# nums = [1001]
for n in nums:
    print(n, ':', s.numberToWords(n))
