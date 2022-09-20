from sys import stdin

k = int(stdin.readline())
n = stdin.readline()
animals = {len(x.strip()):x.lower().strip() for x in stdin.readlines()}
found = False
for kk in animals.keys():
    animal = animals.get(k-kk)
    if animal is not None:
        found = True
        print("Password: "+animal+animals.get(kk))
        break
if not found:
    print("*umuligt*")
