#The function colorMap goes through the original grid starting from top left. It assigns each island in the original grid a colour in the new coloured grid.
#This way the map is coloured only once and all queries can be answered in constant time. Earlier solution was to do one BFS per query, but it was too slow

def colorMap(ma,R,C):
    color = 1
    colored_map = [[0]*C for _ in range(R)]
    for r in range(R): 
        for c in range(C):
            if colored_map[r][c] == 0:
                queue = []
                queue.append((r,c))
                current_val = ma[r][c]
                while queue:
                    r,c = queue.pop() #position to check - only added if it is the correct type of cell
                    colored_map[r][c] = color
                    if r+1 < R and ma[r+1][c] == current_val and colored_map[r+1][c] == 0:
                        queue.append((r+1,c))
                    if r-1 >= 0 and ma[r-1][c] == current_val and colored_map[r-1][c] == 0:
                        queue.append((r-1,c))
                    if c+1 < C and ma[r][c+1] == current_val and colored_map[r][c+1] == 0:
                        queue.append((r,c+1))
                    if c-1 >= 0 and ma[r][c-1] == current_val and colored_map[r][c-1] == 0:
                        queue.append((r,c-1))
                color +=1 #After the while loop this whole island has been colored, so choose a new color
    return colored_map

if __name__ == '__main__':
    from sys import stdin
    
    R,C = list(map(int,stdin.readline().split()))
    mappi = [list(stdin.readline().strip()) for _ in range(R)]
    n = int(stdin.readline())
    coloured_map = colorMap(mappi,R,C)
    for _ in range(n):
        r1,c1,r2,c2 = list(map(int,stdin.readline().split())) #the start and end points (r1,c1) and (r2,c2)
        if mappi[r1-1][c1-1] != mappi[r2-1][c2-1] or coloured_map[r1-1][c1-1] != coloured_map[r2-1][c2-1]: print("neither")
        elif coloured_map[r1-1][c1-1] == coloured_map[r2-1][c2-1] and mappi[r1-1][c1-1] == '1': print("decimal")
        else: print("binary")
            # check if they have the same color in the coloured map