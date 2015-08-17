__author__ = 'Lei Chen'


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)
n6 = ListNode(6)

#     n1->n2->n3
#         |
#n4->n5->n6
n1.next = n2
n2.next = n3
n4.next = n5
n5.next = n6
#n6.next = n2

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        if None == headA or None == headB:
            return None

        if headA == headB:
            return headA

        curA = headA;
        curB = headB;

        loopA = 0;
        loopB = 0;

        while curA != curB:
            if curA.next != None:
                curA = curA.next
            else:
                curA = headB
                loopA += 1

            if curB.next != None:
                curB = curB.next
            else:
                curB = headA
                loopB += 1

            if curA == curB:
                return curA

            if loopA >= 2 or loopB >= 2:
                return None

        return None



s = Solution()

print(s.getIntersectionNode(n1,n1).val)

