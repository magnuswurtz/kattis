import sys
from itu.algs4.stdlib import stdio

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

def move(s,t):
    rootS = find(s)
    rootT = find(t)

    parent[s] = rootT #Check bagefter om det er hurtigere at sætte den til t i stedet

    if rootS == rootT: return 
    
    if size[s] == 1: #If s has no children
        size[rootS] -= 1
        size[rootT] += 1

    elif s == rootS: #If s is the root
        first = True
        newroot = 0

        for index in range(len(size)):
            if first and parent[index] == s:
                newroot = index
                parent[index] = index
                first = False
            elif parent[index] == s:
                parent[index] = newroot
        size[newroot] = size[rootS]-1
        size[s] = 1
        size[rootT] += 1

    else: # If s is not the root but does have some children
        for index in range(len(size)):
            if parent[index] == s:
                parent[rootS]
        size[rootS] -= 1
        size[rootT] += 1
        size[s] = 1

def client():

    n = stdio.readInt()
    m = stdio.readInt()

    for index in range(n): #initialize ds-arrays
        parent.append(index)
        size.append(1)
    
    for index in range(m): # perform operations on m input lines
        op = stdio.readInt()
        s = stdio.readInt()
        t = stdio.readInt()

        if op == 0:
            if find(s) == find(t): print(1)
            else: print(0)
        elif op == 1:
            union(s,t)

        elif op == 2:
            move(s,t)

client()

    





