from sys import stdin

n = int(stdin.readline())
expV = 0.0
probs = [0.0]*n
for i in range(n): probs[i] = float(stdin.readline().split(" ")[1])
probs.sort(reverse = True)
for i in range(n): expV += (i+1)*probs[i]
print(expV)
