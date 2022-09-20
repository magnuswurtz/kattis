from sys import *

d = dict()
line = stdin.readline()
while line != "\n":
    s = line.strip().split()
    d[s[1]] = s[0] 
    line = stdin.readline()

for line in stdin:
    word = d.get(line.strip())
    if word != None:
       print(word)
    else:
        print("eh")