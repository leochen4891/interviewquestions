__author__ = 'Lei Chen'


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def printChain(self):
        print(self.val, end='')
        if self.next != None:
            print(" --> ", end='')
            self.next.printChain()

        print()

    @staticmethod
    def fromArray(array):
        prev = None
        head = None
        for v in array:
            node = ListNode(v)
            if prev: prev.next = node
            if not head: head = node
            prev = node

        return head



