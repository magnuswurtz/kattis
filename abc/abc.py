from sys import stdin, stdout
l = sorted(list(map(int,stdin.readline().strip().split())))
order = list(stdin.readline().strip())

for i in range(3):
    if order[i] == 'A': stdout.write(str(l[0])+ " ")
    elif order[i] == 'B': stdout.write(str(l[1])+ " ")
    else: stdout.write(str(l[2])+ " ")  
