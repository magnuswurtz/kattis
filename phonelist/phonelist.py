#Trie version. Creates a trie of all numbers then run through it. If a subtrie is end of word but has more data, then this is a word which is a prefix of another


class Trie:
    def __init__(self):
        self.data = {}
        self.is_eow = False

    def insert(self,word):
        current = self
        for letter in word:
            if letter not in current.data:
                current.data[letter] = Trie()
            current = current.data[letter]
        current.is_eow = True

def check_prefix(trie):
    current:Trie = trie
    stack = deque()
    stack.appendleft(current)

    while stack:
        current = stack.popleft()
        if current.is_eow and len(current.data) > 0: return False
        else:
            for tr in current.data.keys():
                stack.append(current.data[tr])
    return True

if __name__ == '__main__':
    from sys import stdin
    from collections import deque
    test = int(stdin.readline())

    for _ in range(test):
        n = int(stdin.readline())
        tryhard = Trie()
        for _ in range(n):
            word = stdin.readline().strip()
            tryhard.insert(word)
        if check_prefix(tryhard): print("YES")
        else: print("NO")
