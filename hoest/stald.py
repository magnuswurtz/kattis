from sys import stdin
estimate = 0
m = 0

for sheep in stdin.readlines():
    sheep = sheep.strip()
    if sheep == "Får ind":
        estimate += 1
    elif sheep == "Får ud":
        if estimate > 0:
            estimate -= 1
        elif estimate <= 0:
            m += 1
    m = max(m,estimate)
print(m)