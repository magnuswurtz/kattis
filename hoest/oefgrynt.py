from sys import stdin

n = int(stdin.readline())

for i in range(1,n+1):
    if i % 3 == 0 and i % 5 == 0:
        print("øfgrynt")
    elif i % 3 == 0:
        print("øf")
    elif i % 5 == 0:
        print("grynt")
    elif i % 100 == 0:
        continue
    elif i >= 100:
        print(int(str(i)[1:]))
    else:
        print(i)
    