import sys
import json

testCases = int(sys.stdin.readline())

def solve(instructs:str,listOfIntegers):
    if instructs == "":
        return listOfIntegers
    else:
        if instructs[0] == 'D':
            if listOfIntegers == []:
                return "error"
            return solve(instructs[1:],listOfIntegers[1:])
        elif instructs[0] == 'R': 
            listOfIntegers.reverse()
            return solve(instructs[1:],listOfIntegers)

for i in range(testCases):
    instructions = sys.stdin.readline().strip()
    listSize = int (sys.stdin.readline().strip())
    intList = json.loads(sys.stdin.readline())

    answer = solve(instructions,intList)

    if answer == "error": print(answer)
    else: print(str(answer).replace(" ",""))

