from sys import stdin,stdout 

def main():
    pass


if __name__ == '__main__':
    main()
    n = int(stdin.readline())
    for _ in range(n):
        recording = stdin.readline().split()
        sound = ""
        forbidden = [] #list of the sounds of other animals
        while sound != "the":
            sound = stdin.readline().split()[2]
            forbidden.append(sound)
        print(" ".join(list(filter(lambda elem: elem not in forbidden,recording)))) #filter the original according by only allowing words that are not in the forbidden list