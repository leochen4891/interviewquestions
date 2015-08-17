__author__ = 'Lei Chen'


class Stack:
    # initialize your data structure here.
    def __init__(self):
        self.q1 = []
        self.q2 = []

    # @param x, an integer
    # @return nothing
    def push(self, x):
        while len(self.q1)>0:
            self.q2.append(self.q1.pop(0))

        self.q1.append(x)

        while len(self.q2)>0:
            self.q1.append(self.q2.pop(0))


    # @return nothing
    def pop(self):
        self.q1.pop(0)

    # @return an integer
    def top(self):
        return self.q1[0]

    # @return an boolean
    def empty(self):
        return len(self.q1)==0

s = Stack()

s.push(1)
s.push(2)
print(s.top())

