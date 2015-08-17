__author__ = 'Lei Chen'

class Solution:
    # @param {integer} A
    # @param {integer} B
    # @param {integer} C
    # @param {integer} D
    # @param {integer} E
    # @param {integer} F
    # @param {integer} G
    # @param {integer} H
    # @return {integer}
    def computeArea(self, A, B, C, D, E, F, G, H):
        total = (D-B)*(C-A) + (H-F)*(G-E)

        left = max(A, E)
        right = min(C,G)

        if left >= right: return total

        top = min(D, H)
        bot = max(B, F)

        if bot >= top: return total

        duplicate = (right - left) * (top - bot)
        return total - duplicate

s = Solution()

print(s.computeArea(-3, 0, 3, 4, 3, -1, 9, 2))