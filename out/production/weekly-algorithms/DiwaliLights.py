#!/bin/python3

import os
import sys

#
# Complete the lights function below.
#
def lights(n):
    combs = (2 ** n) % 100000
    return combs - 1


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        result = lights(n)

        fptr.write(str(result) + '\n')

    fptr.close()
