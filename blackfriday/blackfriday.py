from sys import stdin,stdout 
from collections import Counter

def main():
    n = int(stdin.readline())
    l = list(map(int,stdin.readline().split()))
    a = [0]*7
    for number in l: a[number] += 1 #count number of occurences of 1-6
    for i in range(len(a)-1,-1,-1): #iterate backwards. The first number with 1 occurence is the number we're looking for. 
        if a[i] == 1: 
            print(l.index(i)+1) #Print the index of this number +1 since the participants are not zero indexed
            return
    print("None")
    
if __name__ == '__main__':
    main()

