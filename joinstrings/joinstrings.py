from sys import stdin

n = int(stdin.readline())
strings = [input() for _ in range(n)]
output = [[] for _ in range(n)]
lastIdx = 0

for line in stdin.readlines():
    a,b = map(int,line.split())
    output[a-1].append(strings[b-1])
    lastIdx = a-1 

for i in range(len()): # fix printing
    print(strings[lastIdx])
    print("".join(output[lastIdx]))
