from sys import stdin

n = int(stdin.readline())
coordinates = [[]]*n
area = 0
for i in range(n):
    coordinates[i] = list(map(int,stdin.readline().split()))

for i in range(n):
    area += coordinates[i][0]*coordinates[(i+1)%n][1]-coordinates[i][1]*coordinates[(i+1)%n][0]

print(abs(area/2))