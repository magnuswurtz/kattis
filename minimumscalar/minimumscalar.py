from sys import stdin,stdout 

def main(caseNumber,vec1,vec2):
    result = 0
    for i in range(len(vec1)):
        result += vec1[i]*vec2[i]
    print("Case #{}: {}".format(caseNumber,result))


if __name__ == '__main__':
    T = int(stdin.readline())
    for i in range(T):
        n = int(stdin.readline())
        vec1 = sorted(list(map(int,stdin.readline().split())))
        vec2 = sorted(list(map(int,stdin.readline().split())),reverse=True)
        main(i+1,vec1,vec2)