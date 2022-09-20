from sys import stdin
pin = int(stdin.readline())
if pin == 9999:
    print("0000")
else:
    print(str(pin+1).zfill(4)[::-1])