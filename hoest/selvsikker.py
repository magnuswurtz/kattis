from sys import stdin

sætning = stdin.readline().split()
sætning[0], sætning[1], sætning[len(sætning)-1] = sætning[1].capitalize(), sætning[0].lower(),sætning[len(sætning)-1].replace("?","!")

print(" ".join(sætning))
