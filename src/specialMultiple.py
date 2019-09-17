# consider that [1, 2, 3, ..., n] in binary form is [1, 10, 11, ..., n]
# replacing 1 with 9 gives a list of all numbers created using 0s and 9s
#!/bin/python3

import os
import sys

# Complete the solve function below.
def solve(n):
    i = 1
    while True:
        binVersion = bin(i)[2:]
        NineString = str(binVersion).replace("1", "9")
        NineNum = int(NineString)
        if NineNum % n == 0:
            return NineString
        else:
            i = i + 1

if __name__ == '__main__':
    res = solve(7)
    print(res)
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')
    #
    # t = int(input())
    #
    # for t_itr in range(t):
    #     n = int(input())
    #
    #     result = solve(n)
    #
    #     fptr.write(result + '\n')
    #
    # fptr.close()
