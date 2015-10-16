__author__ = 'Lei Chen'

# for i in range(1,10):
#     for j in range(1,10):
#         print(str(i)+' x ' + str(j) + ' = ' + str(i*j))

for size in range(1,10):
    for index in range(1, size+1):
        # print(str(index)+' x ' + str(size) + ' = ' + str(index*size), end='   ')
        # print('{0:1d} x {1:1d} = {2:2d}'.format(index, size, index*size), end='   ')
        print('{0} x {1} = {2:2d}'.format(index, size, index*size), end='   ')
    print('')


