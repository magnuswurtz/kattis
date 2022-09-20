from sys import stdin,stdout
from math import log, ceil
def solve():
    n = int(stdin.readline())
    stdout.write(str(ceil(log(n,2)+1)))
    
if __name__ == '__main__':
    solve()