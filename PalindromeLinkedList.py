__author__ = 'Lei Chen'

from ListNode import ListNode

n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)

n1.val = 1
n2.val = 2
n3.val = 3
n4.val = 2
n5.val = 1

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5

class Solution:
    # @param {ListNode} head
    # @return {boolean}
    def isPalindrome(self, head):
        totalLength = self.getChainLength(head)
        if totalLength <= 1:
            return True

        if totalLength == 2:
            return head.val == head.next.val

        if totalLength == 3:
            return head.val == head.next.next.val

        isOdd = (totalLength % 2 != 0)
        leftChainHead, rightChainHead = self.reverseLink(head, int(totalLength / 2))
        if isOdd: rightChainHead = rightChainHead.next

        # print("leftHead = ", leftChainHead.val)
        # print("rightHead = ", rightChainHead.val)

        left = leftChainHead
        right = rightChainHead

        for i in range(int(totalLength/2)):
            # print(left.val, " -- ", right.val)
            if left.val != right.val:
                return False

            left = left.next
            right = right.next

        return True

    def getChainLength(self, node):
        if node == None: return 0
        length = 1
        while node.next != None:
            length += 1
            node = node.next
        return length

    def reverseLink(self, start, num):
        prev = None
        cur = start
        next = cur.next
        for i in range(num):
            cur.next = prev
            prev = cur
            cur = next
            next = cur.next

        return prev, cur



s = Solution()
print(s.isPalindrome(n1))
