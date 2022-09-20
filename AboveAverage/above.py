from sys import stdin

C = int(stdin.readline())

for _ in range(C):
    line = list(map(int,stdin.readline().split()))
    N = line[0]
    avg = sum(line[1:])/N
    above = len([x for x in line[1:] if x > avg])
    print('{:.3f}%'.format(above/N*100))
