__author__ = 'Lei Chen'

class Solution:
    values = {"0":0, "1":1, "2":2, "3":3, "4":4, "5":5, "6":6, "7":7, "8":8, "9":9}

    # @param {string} str
    # @return {integer}
    def myAtoi(self, str):

        try:
            if len(str) <= 0: raise Exception()

            remain = str.strip()
            neg = False
            if remain[0] == '-' :
                neg = True
                remain = remain[1:]
            elif remain[0] == '+':
                remain = remain[1:]
            remain = remain.lstrip('0')

            parts = remain.split('.')
            if len(parts) > 2:
                raise Exception()

            remain = parts[0]
            if remain[0] not in self.values: raise Exception()

            ret = 0;
            for i, d in enumerate(remain):
                if d not in self.values:
                    break
                ret += self.values[d]
                ret *= 10
            if neg: ret = -ret
            ret = int(ret/10)
            return max(-2147483648, min(2147483647, ret))
        except Exception as e:
            print("invalid format")
            return 0

s = Solution()
print(s.myAtoi("    -4500a123"))
