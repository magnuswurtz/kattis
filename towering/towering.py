from sys import stdin
from typing import List

inp = [int(x) for x in stdin.readline().split()]
h1 = inp.pop()
h2 = inp.pop()

def findTriple(arr:List[int],height1,height2):
    arr.sort()
    for i in range(len(arr)):
        for j in range(i+1,len(arr)):
            for k in range(j+1,len(arr)):
                if arr[i]+arr[j]+arr[k] == height1:
                    return (str(arr.pop(k)) + " " + str(arr.pop(j)) + " " + str(arr.pop(i)) + " " + str(arr.pop()) + " " + str(arr.pop()) + " " + str(arr.pop()))
print(findTriple(inp,h2,h1))