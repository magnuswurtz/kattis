from sys import stdin

symArr = ["/","-","+","*"]
symMap = dict()

for x in symArr:
    for y in symArr:
        for z in symArr:

            exp = str('4 ' + x +' 4 ' + y + ' 4 ' + z +' 4')

            test_exp = exp.replace('4 / 4 / 4', 'int(4 / 4 / 4)')
            value = int(eval(test_exp))
            
            symMap[value] = exp + " = "+ str(value)

numCases = int(stdin.readline())
for n in range(numCases):

    i = int(stdin.readline())

    if symMap.get(i) == None:
        print("no solution")
    else: 
        print(symMap[i])
        