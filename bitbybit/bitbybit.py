from sys import stdin,stdout 

def main(instr:list):
    out = ["?"]*32
    for ins in instr:
        if ins[0] == 'SET':
            out[31-int(ins[1])] = "1"

        elif ins[0] == 'CLEAR':
            out[31-int(ins[1])] = "0"

        elif ins[0] == 'AND':
            i,j = 31-int(ins[1]),31-int(ins[2])
            if out[i] == "1" and out[j] == "1": out[i] = "1" #if both of them is 1 then it's always 1
            elif out[i] == "0" or out[j] == "0": out[i] = "0" #if one of them is 0, we know it's zero
            else: out[i] = "?" #Else we don't know either of them and it could be 0 or 1

        elif ins[0] == 'OR':
            i,j = 31-int(ins[1]),31-int(ins[2])
            if out[i] == "1" or out[j] == "1": out[i] = "1" #If one of them is 1, then we know it's 1
            elif out[i] == "?" or out[j] == "?": out[i] = "?" #If one of them is unknown, it could be either 1 or 0
            else: out[i] = "0" #Else we know that they are both 0 hence it must be 0

    return print("".join(out))
if __name__ == '__main__':
    while True:
        n = int(stdin.readline())
        if n == 0: break
        main([stdin.readline().strip().split() for _ in range(n)])
       
    