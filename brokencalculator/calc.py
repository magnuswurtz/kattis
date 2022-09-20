from sys import stdin
n = int(stdin.readline())
prev = 1
for line in stdin:
    a,op,b = line.split()
    a = int(a)
    b = int(b)
    res = 0
    if op == "*": res = (a*b)**2
    elif op == "+": res = a+b-prev
    elif op == "-": res = (a-b)*prev
    elif op == "/":
        if a % 2 == 0: res = int(a/2)
        else: res = int((a+1)/2)
    prev = res
    print(res)