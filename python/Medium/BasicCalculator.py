__author__ = 'Lei Chen'
'''
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ),
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
'''

# http://www.geeksforgeeks.org/expression-evaluation/
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        ops = []
        nums = []
        for item in self.getItems(s):
            # print(item)
            if item.isdigit():
                nums.append(item)
                continue
            if item == '(':
                ops.append(item)
                continue
            if item in '+-':
                if len(ops) > 0 and ops[-1] in '+-':
                    while len(ops) > 0 and ops[-1] in '+-':
                        n2 = nums.pop()
                        n1 = nums.pop()
                        op = ops.pop()
                        res = self.evalTop(n1, op, n2)
                        nums.append(res)
                ops.append(item)
                continue

            if item == ')':
                while ops[-1] != '(':
                    n2 = nums.pop()
                    n1 = nums.pop()
                    op = ops.pop()
                    res = self.evalTop(n1, op, n2)
                    nums.append(res)
                ops.pop()
                continue

        while len(ops) > 0:
            n2 = nums.pop()
            n1 = nums.pop()
            op = ops.pop()
            res = self.evalTop(n1, op, n2)
            nums.append(res)

        return int(nums.pop())



    def evalTop(self, a, op, b):
        return int(a) + int(b) if op == '+' else int(a) - int(b)

    def getItems(self, s):
        num = ''
        for c in s:
            if c == ' ': continue
            if c in '()+-':
                if len(num) > 0:
                    yield num
                    num = ''
                yield c
            else:
                num += c
        if len(num) > 0:
            yield num

s = Solution()
str = '1+(22+(33+4))+5'
str = "(7)-(0)+(4)"
str = '0*0'
str = '1-11'
print(s.calculate(str))