import sys

def solve():
    line = [char for char in sys.stdin.readline().strip()]
    for c in range(1,len(line)):
        if line[c] == "s" and line[c-1] == "s":
            print("hiss")
            return
    print("no hiss")
solve()