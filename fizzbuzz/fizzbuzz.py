from sys import stdin,stdout 

def main():
    x,y,n = list(map(int,stdin.readline().split()))
    for i in range(1,n+1):
        if i % x == 0: stdout.write("Fizz")
        if i % y == 0: stdout.write("Buzz")
        if not (i % x == 0 or i % y == 0): stdout.write(str(i))
        stdout.write("\n")

if __name__ == '__main__':
    main()