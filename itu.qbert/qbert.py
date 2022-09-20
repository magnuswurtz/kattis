from sys import stdin
from math import inf

def main():
    h = int(stdin.readline())
    damage = list(map(int,stdin.read().split()))
    platforms = [[0 if i == 0 and j == 0 else inf for i in range(j+1) ] for j in range(h+1)]
    next_damage = 0
    for j in range(h):
        for i in range(len(platforms[j])):
            platforms[j+1][i] = min(platforms[j+1][i],platforms[j][i] + damage[next_damage]) #update the cost of the lower left platform
            next_damage+=1
            platforms[j+1][i+1] = min(platforms[j+1][i+1],platforms[j][i] + damage[next_damage]) #update the cost of the lower right platform
            next_damage+=1
    return min(platforms[-1]) #print the minimum value of the bottom floor 

if __name__ == "__main__":
    print(main())