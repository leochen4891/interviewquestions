__author__ = 'Lei Chen'

class MyQueue:
    # initialize your data structure here.
    def __init__(self):
        self.s1 = list()
        self.s2 = list()

    # @param x, an integer
    # @return nothing
    def push(self, x):
        while (len(self.s1)>0):
            self.s2.append(self.s1.pop())

        self.s1.append(x)

        while (len(self.s2)>0):
            self.s1.append(self.s2.pop())

    # @return nothing
    def pop(self):
        ret = self.peek()
        self.s1.remove(ret)
        return ret

    # @return an integer
    def peek(self):
        ret = None
        if not self.empty():
            ret = self.s1[len(self.s1)-1]
        return ret

    # @return an boolean
    def empty(self):
        return len(self.s1) <= 0

s = MyQueue()

s.push(1)
s.push(2)
print(s.peek())
s.push(3)
s.push(4)
