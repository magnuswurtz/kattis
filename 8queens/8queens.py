def check_board(qR:int,qC:int):
    for r in range(8):
        for c in range(8):
            if board[r][c] == '*' and not (r == qR and c == qC):
                if qC == c: return False
                if qR == r: return False
                if abs(qR-r) == abs(qC - c): return False
    return True

    
def solve():
    queens = 0
    for r in range(8):
        for c in range(8):
            if board[r][c] == '*':
                queens += 1
                if not check_board(r,c):
                    print("invalid")
                    return
    if queens == 8:
        print("valid")
    else:
        print("invalid")
if __name__ == "__main__":
    from sys import stdin
    
    board = [[c for c in stdin.readline().strip()] for _ in range(8)]
    solve()