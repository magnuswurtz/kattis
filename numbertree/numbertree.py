from sys import stdin
if __name__ == '__main__':
    line = stdin.readline().split()
    h = int(line[0]) #height of the tree
    s = "" if len(line)<2 else line[1] #if a describtion exists save it in s, otherwise empty string
    idx = 0
    for c in s:
        if c == "L": idx = 2*idx+1 #if left, go to where the child would be in the array-tree
        else: idx = 2*idx+2
    print((2**(h+1)-1)-idx) #subtract the index where we end in the array tree from the number of elements in the tree