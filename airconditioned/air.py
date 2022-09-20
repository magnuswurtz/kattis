import sys

n = int(sys.stdin.readline())
minions = [tuple(map(int,sys.stdin.readline().strip().split(" "))) for x in range(n)] # read minions in as tuples. Minion[0]:lower boundary, minion[1]: upper boundary
rooms = 1

minions.sort(key=lambda elem : elem[1]) #Sort the minions by their upper boundary
compare = minions[0]

for current in range(1,n):
    if minions[current][0] > compare[1]: #If the lower boundary of the current minion is higher than the upper boundary of the compare-minion, then we need a new room and from then on we try to see how many minions fit in this next room. 
        rooms += 1
        compare = minions[current]
print(rooms)