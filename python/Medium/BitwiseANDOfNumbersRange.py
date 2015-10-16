__author__ = 'Lei Chen'
'''
Given a range [m, n] where 0 <= m <= n <= 2147483647,
return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
'''
class Solution(object):
    '''
    0000
    0001
    0010
    0011
    0100
    0101
    0110
    0111
    1000
    1001
    1010
    1011
    1100
    1101
    1110
    1111

    The ith digit(i starts from 0) is 1 from 2**i to 2**(i+1)-1 and repeated every 2**(i+1) times
    if the bit in the result number is 1, the range needs to be in the 1 zone
    '''
    def rangeBitwiseAnd(self, m, n):
        ret = 0;
        start = 1
        for i in range(32): # 2**31 = 2147483647
            end = start*2-1
            repeat = start*2
            if n < start:
                break
            a, b = divmod(m, repeat)
            c, d = divmod(n, repeat)
            if (a == c) and b >= start and d <= end:
                ret = ret | 1 << i
            start *= 2
        return ret

    def rangeBitwiseAnd1(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        ret = m
        for i in range(m+1,n+1):
            ret &= i

        return ret


    def rangeBitwiseAnd2(self, m, n):
        if m == n:
            return m
        zeros = len(bin(m^n)) - 2
        return (n >> zeros) * (2**zeros)

s = Solution()
m = 5
n = 7
for m in range(20):
    for n in range(m, 20):
        a = s.rangeBitwiseAnd1(m,n)
        b = s.rangeBitwiseAnd2(m,n)
        if not a == b:
            print(a,b, ', m = ', m, ', n = ', n)
