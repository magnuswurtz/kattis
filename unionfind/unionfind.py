import sys

parent = []
size = []

def find(s):
    while s!=parent[s]:
        s = parent[s]
    return s

def union(s,t):
    rootS = find(s)
    rootT = find(t)

    if rootS == rootT: return

    if size[rootS] < size[rootT]:
        parent[rootS] = rootT
        size[rootT] += size[rootS]
    else:
        parent[rootT] = rootS
        size[rootS] += size[rootT]


def client():
    
    f = sys.stdin.readline().split(" ")
    n = int(f[0])
    m = int(f[1])


    for index in range(n): #initialize ds-arrays
        parent.append(index)
        size.append(1)
    
    for index in range(m): # perform operations on m input lines
        st = sys.stdin.readline().split(" ")

        op = st[0]
        s = int(st[1])
        t = int(st[2])

        if op == "?":
            if find(s) == find(t): print("yes")
            else: print("no")
        elif op == "=":
            union(s,t)

client()