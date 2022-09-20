import sys

R,C = map(int,sys.stdin.readline().split())

eastern = [int(num) for num in sys.stdin.readline().split()]
northern = [int(num) for num in sys.stdin.readline().split()]

eastern.sort()
northern.sort()

if eastern[-1] == northern[-1]:
    print("possible")
else:
    print("impossible")
