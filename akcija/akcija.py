from sys import stdin

price = 0
n = int(stdin.readline())
books = [int(stdin.readline()) for _ in range(n)]
boooks = sorted(books, reverse = True)

for i in range(n):
    if i % 3 != 2:
        price += boooks[i]

print(price)