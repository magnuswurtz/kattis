def solve(n):
    maxR = 1
    cm = n
    for r in range(1,n):
        for c in range(r,n):
            if r*c == n and r > maxR:
                maxR = r
                cm = c
    for i in range(maxR):
        for j in range(cm):
            idx = j*maxR+i
            print(word[idx],end="")
if __name__ == '__main__': 
    word = list(input().strip())
    solve(len(word))


