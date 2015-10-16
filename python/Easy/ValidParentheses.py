__author__ = 'Lei Chen'

'''
( [ {  and } ] )
'''
class Solution:
    # @param {string} s
    # @return {boolean}
    def isValid(self, s):
        stack = list()
        try:
            for c in s:
                if c == '(' or c == '{' or c == '[':
                    stack.append(c)
                elif c == ')':
                    if stack.pop() != '(': return False
                elif c == ']':
                    if stack.pop() != '[': return False
                elif c == '}':
                    if stack.pop() != '{': return False
                else:
                    pass
        except IndexError:
            return False

        return len(stack) == 0


s = Solution()

print(s.isValid('}}}'))