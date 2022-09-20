
def find_start(map):
    for i in range(len(map)):
        for j in range(len(map[i])):
            if map[i][j] == "P":
                return (i,j)

def search(pos):
    
    return
if __name__ == '__main__':
    from sys import stdin
    c,r = stdin.readline().split()
    map = [[char for char in stdin.readline().strip()] for _ in range(int(r))]
    start = find_start(map)
    gold = 0
    search(start)

print(start)


