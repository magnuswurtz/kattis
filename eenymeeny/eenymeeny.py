#Not a very nice solution, but works. Should be printed on the fly instead of creating multiple lists.
from sys import stdin
rhyme = len(stdin.readline().split())
nNames = int(stdin.readline())
names = stdin.readlines()
team1 = []
team2 = []

startIdx = 0
i = 0
while len(names) > 0:
    startIdx = (startIdx+rhyme-1) % len(names)
    if i % 2 == 0:
        team1.append(names.pop(startIdx))
    else:
        team2.append(names.pop(startIdx))
    i+=1
print(len(team1))
for name in team1:
    print(name.strip())
print(len(team2))
for name in team2:
    print(name.strip())