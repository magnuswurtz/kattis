import sys

lookup = {"(":")","[":"]","{":"}"}

def solve():
    length = int(sys.stdin.readline())
    line = [char for char in sys.stdin.readline().strip()]
    open = []
    for i in range(length):
        if line[i] == " ": continue
        if line[i] == '(' or line[i] == '[' or line[i] == '{': open.append(line[i])
        elif len(open) == 0 or lookup.get(open.pop()) != line[i]: return line[i] + " " + str(i)
    return "ok so far"  

print(solve())