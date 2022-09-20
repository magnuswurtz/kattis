from sys import stdin

def check_dfs(numbers, adj):
    stack:list[set] = []
    for i in range(1,len(numbers)):
        current = numbers[i-1]
        next = numbers[i]
        visited[current] = True
        adj[current] = {x for x in adj[current] if not visited[x]}
        if adj[current]: #Add set to stack if it is not empty
            stack.append(adj[current])
        if not next in stack[-1]:
            return False 
        if next in stack[-1]:
            stack[-1].remove(next)
        if len(stack[-1]) == 0:
            stack.pop()
    #last iteration
    current = numbers[-1]
    adj[current] = {x for x in adj[current] if not visited[x]}
    if adj[current]: #Add set to stack if it is not empty
        stack.append(adj[current])
    if stack and len(stack[-1]) == 0:
        stack.pop() 
    if stack:
        return False
    return True

if __name__ == "__main__":
    N, E = map(int,stdin.readline().split())
    adj = [set() for _ in range(N)]
    visited = [False] * N
    for _ in range(E):
        v,u = stdin.readline().split()
        adj[int(v)].add(int(u))
        adj[int(u)].add(int(v))

    if check_dfs(list(map(int,stdin.readline().split())),adj):
        print("YES")
    else:
        print("NO")