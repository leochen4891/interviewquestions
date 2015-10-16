__author__ = 'Lei Chen'

class Solution(object):
    def addBinary(self, a, b):
        if not a and not b: return ''
        maxLength = max(len(a),len(b))
        a = '0'*(maxLength-len(a))+a
        b = '0'*(maxLength-len(b))+b

        carry = False
        ret = ''
        for i in range(maxLength-1,-1,-1): # length = 5, this gives 4,3,2,1,0
            c1 = a[i]
            c2 = b[i]
            if (carry):
                if (c1 == '1' and c2 == '0') or (c1 == '0' and c2 == '1'):
                    ret = '0' + ret
                elif c1 == '1' and c2 == '1':
                    ret = '1' + ret
                elif c1 == '0' and c2 == '0':
                    ret ='1' + ret
                    carry = False
            else:
                if (c1 == '1' and c2 == '0') or (c1 == '0' and c2 == '1'):
                    ret ='1' + ret
                elif c1 == '1' and c2 == '1':
                    ret ='0' + ret
                    carry = True
                elif c1 == '0' and c2 == '0':
                    ret ='0' + ret
        if carry:
            ret = '1' + ret

        return ret




s = Solution()

a = '1'
b = '1'
print(s.addBinary(a,b))