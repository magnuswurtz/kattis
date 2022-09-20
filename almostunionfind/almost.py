import sys

def find(s):
    while s != parent[s]:
        s = parent[s]
    return s

def union(s,t):
    rootS = find(s)
    rootT = find(t)

    if rootS == rootT: return

    if size[rootS] < size[rootT]:
        parent[rootS] = rootT
        size[rootT] += size[rootS]
        sum[rootT] += sum[rootS]
    else:
        parent[rootT] = rootS
        size[rootS] += size[rootT]
        sum[rootS] += sum[rootT]

def move(s,t):
    rootS = find(s)
    rootT = find(t)

    parent[s] = rootT # move s to the set containing t

    if rootS == rootT: return #ignore if they're already in the same set
    
    if size[s] == 1: #If s has no children
        size[rootS] -= 1
        sum[rootS] -= s
        size[rootT] += 1
        sum[rootT] += s

    elif s == rootS: #If s is the root
        first = True
        newroot = 0
        for index in range(len(size)):
            if parent[index] == s:
                if first:
                    newroot = index
                    first = False     
                parent[index] = newroot
        size[newroot] = size[rootS]-1
        sum[newroot] = sum[rootS]-s
        size[s] = 1
        sum[s] = s
        size[rootT] += 1
        sum[rootT] += s

    else: # If s is not the root but does have some children
        for index in range(len(size)):
            if parent[index] == s:
                parent[index] = parent[rootS] 
        size[rootS] -= 1
        sum[rootS] -= s
        size[rootT] += 1
        sum[rootT] += s
        size[s] = 1
        sum[s] = s

def solveTestCase(sum, size, m):
    
    for index in range(m): # perform operations on m input lines
        secLine = list(map(int,sys.stdin.readline().strip().split()))
        op = secLine[0]

        if op == 1: #Union operation
            s = secLine[1]
            t = secLine[2]
            union(s,t)
        elif op == 2: #move operation
            s = secLine[1]
            t = secLine[2]
            move(s,t)
        elif op == 3: # return the number of elements and the sum of elements in the set containing p
            s = secLine[1]
            print(str(size[find(s)])+" "+str(sum[find(s)]))
for line in sys.stdin:
    line = list(map(int,line.strip().split()))
    n = line[0]
    m = line[1]
    
    parent = [i for i in range(n+1)]
    sum = [i for i in range(n+1)]
    size = [1] * (n+1)

    solveTestCase(sum, size, m)


    