from sys import stdin
n = int(stdin.readline())
forecast = list(map(int,stdin.readline().split()))
warmest = 100
startday = 1
for i in range(n-2):
    temp = max(forecast[i],forecast[i+2])
    if temp < warmest:
        startday = i+1
        warmest = temp
print(startday,warmest)
