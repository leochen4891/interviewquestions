__author__ = 'Lei Chen'

class Solution:
    def __init__(self):
        self.values = dict()
        self.values["I"]= 1
        self.values["IV"]= 4
        self.values["V"]= 5
        self.values["IX"]= 9
        self.values["X"]= 10
        self.values["XL"]= 40
        self.values["L"]= 50
        self.values["XC"]= 90
        self.values["C"]= 100
        self.values["CD"]= 400
        self.values["D"]= 500
        self.values["CM"]= 900
        self.values["M"]= 1000

    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        print("s =", s)
        ret = 0
        remain = s
        count = len(s)
        while count > 0:
            if count >= 2 and remain[0:2] in self.values:
                ret += self.values[remain[0:2]]
                remain = remain[2:]
                count -= 2
            else:
                ret += self.values[remain[0:1]]
                remain = remain[1:]
                count -= 1

        return ret

s = Solution()

print(s.romanToInt("I"),	1)
print(s.romanToInt("II"),	2)
print(s.romanToInt("III"),	3)
print(s.romanToInt("IV"),	4)
print(s.romanToInt("V"),	5)
print(s.romanToInt("VI"),	6)
print(s.romanToInt("VII"),	7)
print(s.romanToInt("VIII"),	8)
print(s.romanToInt("IX"),	9)
print(s.romanToInt("X"),	10)
print(s.romanToInt("XI"),	11)
print(s.romanToInt("XII"),	12)
print(s.romanToInt("XIII"),	13)
print(s.romanToInt("XIV"),	14)
print(s.romanToInt("XV"),	15)
print(s.romanToInt("XVI"),	16)
print(s.romanToInt("XVII"),	17)
print(s.romanToInt("XVIII"),	18)
print(s.romanToInt("XIX"),	19)
print(s.romanToInt("XX"),	20)
print(s.romanToInt("XL"),	40)
print(s.romanToInt("XLI"),	41)
print(s.romanToInt("L"),	50)
print(s.romanToInt("LI"),	51)
print(s.romanToInt("LIX"),	59)
print(s.romanToInt("LX"),	60)
print(s.romanToInt("LXI"),	61)
print(s.romanToInt("LXXXIX"),	89)
print(s.romanToInt("XC"),	90)
print(s.romanToInt("XCIX"),	99)
print(s.romanToInt("C"),	100)