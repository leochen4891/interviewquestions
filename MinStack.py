__author__ = 'Lei Chen'

import random
class MinStack:
    # initialize your data structure here.
    def __init__(self):
        self.stack = []
        self.minIndices = []
        self.N = 0

    # @param x, an integer
    # @return nothing
    def push(self, x):
        self.stack.append(x)

        if self.N == 0:
            self.minIndices.append(0)
        else:
            prevMinIndex = self.minIndices[self.N-1]
            prevMinValue = self.stack[prevMinIndex]

            self.minIndices.append(prevMinIndex if prevMinValue < x else self.N)

        self.N += 1

    # @return nothing
    def pop(self):
        self.stack.pop()
        self.minIndices.pop()
        self.N -= 1


    # @return an integer
    def top(self):
        return self.stack[self.N-1] if self.N > 0 else None

    # @return an integer
    def getMin(self):
        return self.stack[self.minIndices[self.N-1]] if self.N > 0 else None

s = MinStack()

s.push(3)
s.push(4)
s.push(2)
s.push(5)
s.push(-2)