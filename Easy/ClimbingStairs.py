__author__ = 'Lei Chen'
'''
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
'''
#      .... n-2, n-1, n, to reach step n, one can take two 1-step from n-1 or one 2-step from n-2
#   0,  1,  2,  3,  4,  5
#   1   1  0+2 1+2 2+3 3+5
class Solution(object):
    def climbStairs(self, n):
        if n <= 1: return 1
        steps = [None]*(n+1)
        steps[0]=steps[1]=1
        for i in range(2, n+1):
            steps[i] = steps[i-2]+steps[i-1]
        return steps[n]

s = Solution()
for i in range(6):
    print(i, ":", s.climbStairs(i))


