import sys

n = int(sys.stdin.readline())
input = list(map(int,sys.stdin.readline().strip().split(" ")))
saved = 0
input.sort(reverse=True)

for item in range(2,len(input),3):
    saved += input[item]

print(saved)