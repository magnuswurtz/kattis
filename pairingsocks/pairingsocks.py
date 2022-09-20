import sys

def pair():
    n = int(sys.stdin.readline())
    stack = sys.stdin.readline().strip().split(" ")
    stack2 = []
    stack2.insert(0,stack.pop(0))
    moves = 0
    while stack and stack2:
        if stack[0] == stack2[0]:
            stack.pop(0)
            stack2.pop(0)
        else:
            stack2.insert(0,stack.pop(0))
        moves += 1
    print(moves)
if __name__ == '__main__':
    pair()
