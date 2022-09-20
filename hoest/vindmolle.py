from sys import stdin
current, next = map(int,stdin.readlines())
medUret = 0
modUret = 0
if current > next:
    medUret = (360-current)+next
    modUret = current-next
else:
    medUret = next-current
    modUret = current+(360-next)

if medUret <= modUret:
    print(medUret) 
else:
    print(-modUret)