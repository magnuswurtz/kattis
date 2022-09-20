from typing import Counter

def solve(A,N,t):
    if t == 1:
        B = set(A)
        for x in range(1,7777):
            y = 7777-x
            if x in B and y in B: #If both number and the 7777-number is in the set, then we've found two numbers that summed equals 7777. Only works becausew 7777 is uneven, otherwise x and y could be the same number
                return ["Yes"]
        return["No"]
    elif t == 2:
        return ["Contains duplicate"] if len(set(A)) < N else ["Unique"] 
    elif t == 3:
        a,b = Counter(A).most_common(1)[0] #count the occurences of all elements and return the most common. If it appears more than N/2 times, return the number
        return [a] if b > N/2 else [-1]
    elif t == 4:
        A.sort()
        idx = N/2
        return [A[int(idx-1)],A[int(idx)]] if N % 2 == 0 else [A[int(idx)]] #If N is even output two median values, else just the one
    elif t == 5:
        return sorted(filter(lambda x: 99 < x < 1000,A)) #filter the list and then sort

if __name__ == '__main__':
    from sys import stdin
    N,t = map(int,stdin.readline().split())
    A = list(map(int,stdin.readline().split()))
    print(*solve(A,N,t))
