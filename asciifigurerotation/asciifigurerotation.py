def solve():
    n = int(stdin.readline())
    while n != 0:
        output = [[' ' for _ in range(n)] for _ in range(100)]

        for row_number in range(n):
            row = stdin.readline().rstrip()
            for col in range(len(row)):
                c = row[col]
                if c == '-':    
                    output[col][(n-1)-row_number] = '|'
                elif c == "|":
                    output[col][(n-1)-row_number] = '-'
                else:
                    output[col][(n-1)-row_number] = row[col]
        for row in output:
            if not "".join(row).isspace():    
                print(("".join(row).rstrip()))
        n = int(stdin.readline())
        if n != 0:
            print()

if __name__ == "__main__":
    from sys import stdin
    solve()