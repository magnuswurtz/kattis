import sys

testcases = int(sys.stdin.readline())

for i in range(testcases):
    sys.stdin.readline() #skip first empty line
    children = int(sys.stdin.readline())
    candies = 0
    for j in range(children): candies += int(sys.stdin.readline())
    if candies % children == 0: print("YES")
    else: print("NO")