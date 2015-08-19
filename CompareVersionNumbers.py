__author__ = 'Lei Chen'

class Solution:
    # @param {string} version1
    # @param {string} version2
    # @return {integer}
    def compareVersion(self, version1, version2):
        vs1 = version1.split('.')
        vs2 = version2.split('.')
        num1 = 0
        num2 = 0
        max_size = max(len(vs1), len(vs2))
        for i in range(max_size):
            section1='0'
            section2='0'
            if i < len(vs1): section1 = (vs1[i])
            if i < len(vs2): section2 = (vs2[i])

            if i == 0:
                section1, section2 = str(int(section1)), str(int(section2))

            section_size = max(len(section1), len(section2))
            num1 *= pow(10, section_size)
            num2 *= pow(10, section_size)

            # num1 += int(section1+'0'*(section_size - len(section1)))
            # num2 += int(section2+'0'*(section_size - len(section2)))
            num1 += int(section1.zfill(section_size - len(section1)))
            num2 += int(section2.zfill(section_size - len(section2)))

        if num1 == num2:return 0
        return 1 if num1 > num2 else -1

s = Solution()

print(s.compareVersion('1.1', '1.10'))