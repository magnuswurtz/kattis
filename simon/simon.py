from sys import stdin

if __name__ == '__main__':
    n = stdin.readline()
    for line in stdin:
        line = line.split()
        if len(line) > 2 and line[0] == "simon" and line[1] == "says":
            print(*line[2:])
        else:
            print()
