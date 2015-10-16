__author__ = 'Lei Chen'

"""
print some examples to get the following table:
    27  9   3   1
------------------
1   0   0   0   1
2   0   0   1  -1
3   0   0   1   0
4   0   1   1   1
5   0   1  -1  -1
6   0   1  -1   0
7   0   1  -1   1
8   0   1   0  -1
9   0   1   0   0
10  0   1   0   1
11  0   1   1  -1
12  0   1   1   0
13  0   1   1   1
14  1  -1  -1  -1

where -1 means L, 0 means -, 1 means right
startIndex = [1,2,5,14,41 ...] which is the sum of [0,1,3,9,27, ...} up to n and plus one
segmentLength = [1,3,9,27,...]
rotationLength = [3,9,27,81...]


for weight p
conceptually the result is (x - startIndex[p]) % rotationLength // segmentLength + '-1'
"""
MAX_X = 1000000000

# weights under MAX_X can be pre-calculated
weights = [1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049,
            177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467]
MAX_POWER = len(weights)+1

# start_index can also be pre-calculated
# start_index = [1]
# sum = 0
# for weight in weights:
#     sum += weight
#     start_index.append(sum+1)
start_index = [1, 2, 5, 14, 41, 122, 365, 1094, 3281, 9842, 29525, 88574, 265721, 797162, 2391485,
               7174454, 21523361, 64570082, 193710245, 581130734, 1743392201]

# segmentLength = [3**power for power in range(0,MAX_POWER)]
segmentLength = [1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467, 3486784401]

# rotationLength = [seg * 3 for seg in segmentLength]
rotationLength = [3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467, 3486784401, 10460353203]

# for output
letters = ['L', '-', 'R']

def answer(x):
    output = []
    for p in range(MAX_POWER):
        if start_index[p] > x:
            break
        offset = ((x-start_index[p])%rotationLength[p]//segmentLength[p]+2)%3 - 1
        output.append(offset)

    # print (x, output)
    return [letters[offset+1] for offset in output]

# TEST
# for x in range(1,42):
#     res = answer(x)
#     print(res)


