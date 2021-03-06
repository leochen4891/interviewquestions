__author__ = 'Lei Chen'
'''
Given a string of numbers and operators, return all possible
results from computing all the different possible ways to group
numbers and operators. The valid operators are +, - and *.

Example 1
Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
'''
class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        ops = set(['+','-','*'])
        ret = []
        hasOp = False
        for i, c in enumerate(input):
            if c in ops:
                hasOp = True
                res1 = self.diffWaysToCompute(input[:i])
                res2 = self.diffWaysToCompute(input[i+1:])
                if c == '+':ret += [v1+v2 for v1 in res1 for v2 in res2]
                elif c == '-':ret += [v1-v2 for v1 in res1 for v2 in res2]
                else: ret += [v1*v2 for v1 in res1 for v2 in res2]

        if not hasOp:
            ret += [int(input)]
        return ret

expressions = ['2-1-1', '2*3-4*5']

s = Solution()
for exp in expressions:
    print(s.diffWaysToCompute(exp))



