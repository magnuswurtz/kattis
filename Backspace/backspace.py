from sys import stdin

inp = list(stdin.readline().strip())
out = ['']*len(inp)
k = 0
for i in range(len(inp)):
    if inp[i] != "<":
        out[k] = inp[i]
        k += 1
    else:
        k -= 1
        out[k] = ''
print("".join(out))