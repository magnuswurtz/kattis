from heapq import heapreplace


def buildTree(s):
    pq = [] #priority queue
    dist_to[s] = 0
    heappush(pq,(0,s))
    
    while len(pq) > 0:
        (currDist, current) = heappop(pq)
        for (neighbour, weight) in adj[current]:
            distanceToNeighbour = currDist + weight
            if distanceToNeighbour < dist_to[neighbour]:
                dist_to[neighbour] = distanceToNeighbour
                heappush(pq,(distanceToNeighbour,neighbour))

if __name__ == '__main__':
    from sys import stdin
    from math import inf
    from heapq import heappop, heappush

    while True:
        line = stdin.readline().strip()
        nodes, edges, queries, s = list(map(int,line.split()))
        if line == "0 0 0 0":
            break
        #initialize stuff needed for Dijkstra
        adj = [list() for _ in range(nodes)]
        dist_to = [inf]*nodes
        for _ in range(edges): #read in graph
            u,v,weight = list(map(int,stdin.readline().split()))
            adj[u].append((v,weight))

        buildTree(s)

        for _ in range(queries):
            r = int(stdin.readline())
            if dist_to[r] != inf: print(dist_to[r])
            else: print("Impossible")

