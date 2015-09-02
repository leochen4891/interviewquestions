__author__ = 'Lei Chen'

'''
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
'''

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        positions = [(1,5,10,'I','V','X'),
                     (10, 50, 100,'X','L','C'),
                     (100, 500, 1000, 'C', 'D', 'M'),
                     (1000, 5000, 10000, 'M', '-', '-')]
        ret = ''
        for i in range(3,-1,-1):
            pos = positions[i]
            d, m = divmod(num, pos[0])
            section = self.build(d*pos[0], *pos)
            # print(section)
            ret += section
            num = m

        return ret

    def build(self,n, l, m, h, lc, mc, hc):
        ret = ''
        if n == h:
            ret += hc
        elif n >= l * 9:
            ret += lc + hc
        elif n >= m:
            ret += mc + lc * int((n-m)/l)
        elif n >= l*4:
            ret += lc + mc
        else:
            ret += lc * int(n/l)

        return ret

s = Solution()
# for i in range(1,11):
#     print(s.build(i, 1,5,10,'I','V','X'))
# for i in range(10,101,10):
#     print(s.build(i, 10, 50, 100,'X','L','C'))

print(s.intToRoman(3999))

