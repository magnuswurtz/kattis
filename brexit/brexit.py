from sys import stdin,stdout 
from collections import deque
#Changed adj[0] from a list to a set which made the solution MUCH faster

def main():
    nCountries, nPartnerships,homeCountry,startCountry = list(map(int,stdin.readline().split()))
    adj = [[set(),0] for _ in range(nCountries+1)] #initialize adjacency list. Each country has a set for it's partners and a counter for the number of initial partnerships

    for _ in range(nPartnerships): #Add partnerships to adjacency list
        c1,c2 = list(map(int,stdin.readline().split()))
        adj[c1][0].add(c2)
        adj[c1][1] += 1 
        adj[c2][0].add(c1)
        adj[c2][1] += 1

    queue = deque() #Queue with the countries that leave the union
    queue.append(startCountry) 
    
    while queue:
        country = queue.pop()
        if country == homeCountry:
            print("leave")
            return
        for partner in adj[country][0]: #Go through all partners. 
            adj[partner][0].remove(country) #Remove the leaving country from the partnerset.
            if len(adj[partner][0])<=adj[partner][1]//2: #If the remaining number of partners is less than half of the initial number of partners, add the country to the leaving queue
                queue.append(partner)
    print("stay")
if __name__ == '__main__':
     main()