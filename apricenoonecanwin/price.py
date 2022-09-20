from sys import stdin

n, X = map(int,stdin.readline().split())
nums = sorted(list(map(int,stdin.readline().split())))

offers = 1
for i in range(1,n):
    if nums[i]+nums[i-1] > X: break
    offers = i+1

print(offers)