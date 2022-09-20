from sys import stdin

def isIsland(arr):
    for i in range(1,len(arr)):
        if arr[i] <= arr[0] or arr[i] <= arr[len(arr)-1]:
            return False
    return True

def solve(seq):
    islands = 0
    for i in range(1,len(seq)):
        for j in range(len(seq)-1,0,-1):
            if seq[i] > seq[i-1]:
                if isIsland(seq[i:j]): 
                    islands += 1
    return str(islands)

P = int(stdin.readline())

for i in range(1,P+1):
    sequence = list(map(int,stdin.readline().split()))
    sequence.pop(0)
    print(str(i) + " " + solve(sequence))
