from sys import stdin
from math import inf
k = int(stdin.readline())
nextYear = inf
for i in range(k):
    lastYear, c1, c2 = map(int,stdin.readline().split())
    n = 2022-lastYear
    while not (n % c1 == 0 and n % c2 == 0): n+=1
    nextYear = min(nextYear,lastYear + n)
print(nextYear)