def DFS(numbers):
    number = numbers[0]
    next = numbers[1]
    visited[number] = True
    while adj[number]:
        adj[number].remove(next)
        if not visited[next]



if __name__ == "__main__":
    from sys import stdin

    N, E = map(int,stdin.readline().split())
    adj = [set() for _ in range(N)]
    visited = [False] * N
    for _ in range(E):
        v,u = stdin.readline().split()
        adj[int(v)].add(int(u))
        adj[int(u)].add(int(v))
    numbers = list(map(int,stdin.readline().split()))

    DFS(numbers)