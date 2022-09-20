from sys import stdin

def censor(r:int,c:int):
    matrix[r][c] = "."#censor this point
    if c+1 < w and (matrix[r][c+1] == "O" or matrix[r][c+1] == "#"): censor(r,c+1) #right
    if c-1 >= 0 and (matrix[r][c-1] == "O" or matrix[r][c-1] == "#"): censor(r,c-1) #left
    if r-1 >= 0 and (matrix[r-1][c] == "O" or matrix[r-1][c] == "#"): censor(r-1,c) #up
    if r+1 < h and (matrix[r+1][c] == "O" or matrix[r+1][c] == "#"): censor(r+1,c) #down

if __name__ == "__main__":
    h,w = list(map(int,stdin.readline().split()))
    matrix = [[char for char in x.strip()] for x in stdin.readlines()]
    censor(0,0) #recursively censor all neighbouring points until all neighbours are dots

    for line in matrix: #print result
        print("".join(line))
