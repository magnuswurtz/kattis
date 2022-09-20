from sys import *
import math
x, y, n = map(int,stdin.readline().split())
distances = []

for _ in range(n):
    s, t, r = map(int,stdin.readline().split())
    distances.append(max(0,(math.sqrt(((x-s)**2)+((y-t)**2)))-r))
distances.sort()

print(math.floor(distances[2]))
