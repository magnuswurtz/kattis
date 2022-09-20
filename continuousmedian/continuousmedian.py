from sys import stdin
import heapq
from math import floor
n = int(stdin.readline())

for i in range(n):
    l = int(stdin.readline())
    arr = list(map(int,stdin.readline().split()))
    lower = []; heapq.heapify(lower) #PQ for lower half - is turned max PQ by reversing the values when inserted
    upper=  []; heapq.heapify(upper) #min PQ for upper half
    medianSum = 0
    for j in arr:
        if len(upper) == 0: #the first item gets added to upperhalf
            heapq.heappush(upper,j)
        else:
            if j < upper[0]: #if the item is smaller than the median, add id to the lower half 
                heapq.heappush(lower,-j)
                if len(lower)>len(upper): heapq.heappush(upper,-heapq.heappop(lower)) #make sure to rebalance the two halves
            else: #else add it the the upper half
                heapq.heappush(upper,j) 
                if len(upper)>1+len(lower): heapq.heappush(lower,-heapq.heappop(upper)) #rebalance

        if len(upper) == len(lower):
            medianSum += floor((upper[0]-lower[0])/2)
        else: medianSum += upper[0]
    print(medianSum)


