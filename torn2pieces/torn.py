from sys import stdin

n = int(stdin.readline().strip())
graph: "dict[str,list[str]]" = {}
visited = {}
parent = {}
queue = []

def addEdge(v,u):
    graph[v].append(u)
    graph[u].append(v)

for i in range(n):
    line = stdin.readline().split()
    present = line[0]
    for station in line:
        if station not in graph:
            graph[station] = []
        addEdge(station,present)
        visited[station] = False
        parent[station] = None

start, end = stdin.readline().split()

def bfs():
    visited[start] = True
    queue.append(start)
    while queue:
        present = queue.pop()
        for val in graph[present]:
            if not visited[val]:
                visited[val] = True
                parent[val] = present
                queue.append(val)

def findRoute():
    out = [end]
    next = end
    while parent[next] != None:
        out.append(parent[next])
        next = parent[next]
    return " ".join(reversed(out))
    
if start not in graph or end not in graph: #If either start or end is not present in the graph
    print("no route found")
else: 
    bfs()
    if visited[end]: print(findRoute())
    else: print("no route found")