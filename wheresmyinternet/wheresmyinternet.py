def solve():
    n,m = map(int,stdin.readline().strip().split())
    not_connected = 0
    adj = [list() for _ in range(n)]
    visited = [False for _ in range(n)]

    for line in stdin:
        u,v = map(int,line.strip().split())
        adj[u-1].append(v-1)
        adj[v-1].append(u-1)
    
    q = deque()
    visited[0] = True
    q.appendleft(0)
    while q:
        popped = q.popleft()
        for neighbour in adj[popped]:
            if not visited[neighbour]:
                visited[neighbour] = True
                q.appendleft(neighbour)
    for idx,house in enumerate(visited):
        if not house:
            not_connected += 1
            stdout.write(str(idx+1) +"\n")
    if not_connected == 0:
        stdout.write("Connected")

if __name__ == '__main__':
    from sys import stdin,stdout
    from collections import deque
    solve()
