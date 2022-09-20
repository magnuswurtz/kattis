import sys
#STADIG TIME LIMIT EXCEEDED!
account = []
n,q = sys.stdin.readline().strip().split(" ")
n = int(n)
q = int(q)

for i in range(n):
    account.append(0)

def setter(i,x):
    account[i] = x

def restart(x):
    for i in range(len(account)):
        account[i] = x

while(q > 0):
    line = sys.stdin.readline().strip().split(" ")

    if line[0] == "SET":
        setter(int(line[1])-1, int(line[2]))
    elif line[0] == "PRINT":
        print(account[int(line[1])-1])
    else:
        restart(int(line[1]))
    q -= 1
