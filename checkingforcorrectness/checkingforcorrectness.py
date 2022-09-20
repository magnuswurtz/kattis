from sys import stdin,stdout 
from math import pow
##Correct results, but too slow. The problem is the last operation
if __name__ == '__main__':
    for line in stdin:   
        one,op,two = line.split()
        if op == "+": print(int(one) + int(two) % 10000)
        elif op == "*": print(int(one) * int(two) % 10000)
        elif op == "^": res = print(int(one)**int(two) % 10000)
        
