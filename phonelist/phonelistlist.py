#List version to see if this is faster than the trie version.
#Get the list, sort it ALPHABETICALLY, then traverse it and check for each phone number, if the previous is a prefix of this one.
#Not as clever as the trie version, but MUCH faster in practice!
def solve():
    test = int(stdin.readline())
    for _ in range(test):
        n = int(stdin.readline())
        number_list = [stdin.readline().strip() for _ in range(n)]
        number_list.sort()
        check(number_list)
def check(sorted_list):
    for idx in range(1,len(sorted_list)):
        if sorted_list[idx-1] == sorted_list[idx][:len(sorted_list[idx-1])]:
            print("NO")
            return
    print("YES")
    return
if __name__ == '__main__':
    from sys import stdin
    solve()
