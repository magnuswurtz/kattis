from sys import stdin

n = int(stdin.readline())
runners = []
bestTeam = []
bestTime = float("inf")
for i in range(n):
    runners.append(stdin.readline().split())
runners.sort(key=lambda runner: float(runner[2]))

for i in range(n):
    tempTeam = []
    tempTeam.append(runners[i])
    time = float(runners[i][1])
    j = 0
    while len(tempTeam) < 4:
        if i != j:
            tempTeam.append(runners[j])
            time += float(runners[j][2])
        j+=1
    if time < bestTime:
        bestTeam = tempTeam
        bestTime = time
print(bestTime)
for runner in bestTeam:
    print(runner[0])
