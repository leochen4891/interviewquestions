__author__ = 'Lei Chen'

'''
Given a string S, find the longest palindromic substring in S. You may assume that
the maximum length of S is 1000, and there exists one unique longest palindromic substring.
'''

# find 'xx' and 'xyx' first as potential start points
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        size = len(s)
        if size <= 1: return s
        longest = 1
        longestLeft = 0
        longestRight = 0

        s2 = set()
        s3 = set()

        for i in range(size-1):
            if s[i] == s[i+1]: s2.add((i,i+1))

        for i in range(size - 2):
            if s[i] == s[i+2]: s3.add((i,i+2))

        for cl,cr in s2:
            if (cl - int(longest/2) < 0 or cr + int(longest/2) >= size):
                continue
            l,r = self.isPalindrom(s, cl, cr)
            if r-l+1 > longest:
                longest, longestLeft, longestRight = r-l+1, l, r


        for cl, cr in s3:
            if (cl + 1 - int(longest/2) < 0 or cr - 1 + int(longest/2) >= size):
                continue
            l, r = self.isPalindrom(s, cl, cr)
            if r-l+1 > longest:
                longest, longestLeft, longestRight = r-l+1, l, r

        return s[longestLeft:longestRight+1]



    def isPalindrom(self,s, l, r):
        while True:
            if s[l] != s[r]:
                l,r = l+1,r-1
                break
            if l == 0 or r == len(s)-1: break
            l,r = l-1,r+1
        return l,r





s = Solution()

str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
# str = 'cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj'
# str = "123432"
# str = '234321'
str = 'bbb'
print(s.longestPalindrome(str))
print(s.isPalindrom(str,0,1))
