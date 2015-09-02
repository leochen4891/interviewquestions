__author__ = 'Lei Chen'
'''
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
'''
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        ops = []
        nums = []
        prio = dict()
        prio['+'] = 1
        prio['-'] = 1
        prio['*'] = 2
        prio['/'] = 2
        for item in self.getItems(s):
            # print(item)
            if item.isdigit():
                nums.append(item)
                continue
            if item == '(':
                ops.append(item)
                continue
            if item in prio:
                if len(ops) > 0 and prio[ops[-1]] >= prio[item]:
                    while len(ops) > 0 and prio[ops[-1]] >= prio[item]:
                        res = self.evalTop(nums.pop(), ops.pop(), nums.pop())
                        nums.append(res)
                ops.append(item)
                continue

            if item == ')':
                while ops[-1] != '(':
                    res = self.evalTop(nums.pop(), ops.pop(), nums.pop())
                    nums.append(res)
                ops.pop()
                continue

        while len(ops) > 0:
            res = self.evalTop(nums.pop(), ops.pop(), nums.pop())
            nums.append(res)

        return int(nums.pop())


    def evalTop(self, b, op, a):
        if op == '+': return int(a) + int(b)
        elif op == '-': return int(a) - int(b)
        elif op == '*': return int(a) * int(b)
        else: return int(a) // int(b)

    def getItems(self, s):
        num = ''
        for c in s:
            if c == ' ': continue
            if c in '()+-*/':
                if len(num) > 0:
                    yield num
                    num = ''
                yield c
            else:
                num += c
        if len(num) > 0:
            yield num

s = Solution()
str = '0*0'
str = '1+2*3-4'
print(s.calculate(str))