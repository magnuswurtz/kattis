from sys import stdin
from math import ceil

N,K,H = [int(x) for x in stdin.readline().split()]
if N-K*H > 0:
    print(ceil((N-K*H)/H))
else: print(0)