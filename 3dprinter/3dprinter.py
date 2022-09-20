from sys import stdin,stdout 

def main(n:int):
    if n == 1:
        stdout.write("1")
        return
    for i in range(1,10000):
        if n<=2**i:
            stdout.write(str(i + 1))
            return
if __name__ == '__main__':
    n = int(stdin.readline())
    
    main(n)
