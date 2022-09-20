from sys import stdin
from collections import deque
from math import inf

def bfs(grid,R,C):
    queue = deque()
    dist_to = [[inf for _ in range(C)] for _ in range(R)]
    queue.appendleft((0,0))
    dist_to[0][0] = 0
    while queue:
        r,c = queue.pop()
        currentVal = grid[r][c]
        if r+currentVal < R and dist_to[r][c] + 1 < dist_to[r+currentVal][c]:
            queue.appendleft((r+currentVal,c))
            dist_to[r+currentVal][c] = dist_to[r][c]+1
        if r-currentVal >= 0 and dist_to[r][c] + 1 < dist_to[r-currentVal][c]:
            queue.appendleft((r-currentVal,c))
            dist_to[r-currentVal][c] = dist_to[r][c]+1
        if c+currentVal < C and dist_to[r][c] + 1 < dist_to[r][c+currentVal]:
            queue.appendleft((r,c+currentVal))
            dist_to[r][c+currentVal] = dist_to[r][c]+1
        if c-currentVal >= 0 and dist_to[r][c] + 1 < dist_to[r][c-currentVal]:
            queue.appendleft((r,c-currentVal))
            dist_to[r][c-currentVal] = dist_to[r][c]+1
    if dist_to[R-1][C-1] != inf: print(dist_to[R-1][C-1])
    else: print(-1)
if __name__ == '__main__':
    R,C = map(int,stdin.readline().split())
    grid  = [[int(c) for c in stdin.readline().strip()] for _ in range(R)]
    bfs(grid,R,C)