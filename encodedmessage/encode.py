import sys
import math
n = int (sys.stdin.readline())
for i in range(n):
    line = sys.stdin.readline().strip()
    sqr = int (math.sqrt(len(line)))
    x = [[line[i+j] for j in range(0,len(line),sqr)] for i in reversed(range(0,sqr))]
    res = "".join(["".join(y) for y in x])
    print(res)