from sys import stdin,stdout 
#NOT SOLVED
def main():
    D,R,T = list(map(int,stdin.readlines()))
    
    rCandles = [0]*46
    tCandles = [0]*46
    for i in range(4,46):
        rCandles[i] = rCandles[i-1]+i
    for i in range(3,46):
        tCandles[i] = tCandles[i-1]+i
    for i in range(4,46):




if __name__ == '__main__':
    main()