__author__ = 'Lei Chen'

'''
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
'''
import math
import re

class Solution:
    # @param {integer} n
    # @return {integer}
    def trailingZeroes(self, n):
        zeros = 0
        factor = 5
        while factor <= n:
            zeros += int(n / factor)
            factor *= 5
        return zeros


test_cases = list()

test_cases.append("1")
test_cases.append("1")
test_cases.append("2")
test_cases.append("6")
test_cases.append("24")
test_cases.append("120")
test_cases.append("720")
test_cases.append("5040")
test_cases.append("40320")
test_cases.append("362880")
test_cases.append("3628800")
test_cases.append("39916800")
test_cases.append("479001600")
test_cases.append("6227020800")
test_cases.append("87178291200")
test_cases.append("1307674368000")
test_cases.append("20922789888000")
test_cases.append("355687428096000")
test_cases.append("6402373705728000")
test_cases.append("121645100408832000")
test_cases.append("2432902008176640000")
test_cases.append("51090942171709440000")
test_cases.append("1124000727777607680000")
test_cases.append("25852016738884976640000")
test_cases.append("620448401733239439360000")
test_cases.append("15511210043330985984000000")
test_cases.append("403291461126605635584000000")
test_cases.append("10888869450418352160768000000")
test_cases.append("304888344611713860501504000000")
test_cases.append("8841761993739701954543616000000")
test_cases.append("265252859812191058636308480000000")
test_cases.append("8222838654177922817725562880000000")
test_cases.append("263130836933693530167218012160000000")
test_cases.append("8683317618811886495518194401280000000")
test_cases.append("295232799039604140847618609643520000000")
test_cases.append("10333147966386144929666651337523200000000")
test_cases.append("371993326789901217467999448150835200000000")
test_cases.append("13763753091226345046315979581580902400000000")
test_cases.append("523022617466601111760007224100074291200000000")
test_cases.append("20397882081197443358640281739902897356800000000")
test_cases.append("815915283247897734345611269596115894272000000000")
test_cases.append("33452526613163807108170062053440751665152000000000")
test_cases.append("1405006117752879898543142606244511569936384000000000")
test_cases.append("60415263063373835637355132068513997507264512000000000")
test_cases.append("2658271574788448768043625811014615890319638528000000000")
test_cases.append("119622220865480194561963161495657715064383733760000000000")
test_cases.append("5502622159812088949850305428800254892961651752960000000000")
test_cases.append("258623241511168180642964355153611979969197632389120000000000")
test_cases.append("12413915592536072670862289047373375038521486354677760000000000")
test_cases.append("608281864034267560872252163321295376887552831379210240000000000")
test_cases.append("30414093201713378043612608166064768844377641568960512000000000000")


s = Solution()

trailing_zeros_pattern = re.compile("0*$")
for i in range(len(test_cases)):
    num_of_zeros = re.findall(trailing_zeros_pattern, test_cases[i])
    print(i, ":", "expected =", len(num_of_zeros[0]), ", output =", s.trailingZeroes(i))
