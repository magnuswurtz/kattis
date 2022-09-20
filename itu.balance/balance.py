from itu.algs4.stdlib import stdio

str = stdio.readLine()
stacki = []
def isBalanced():
    
    if str[0] == "]" or str[0] == ")":
        print("0")
        return
    if len(str) % 2 == 1:
        print("0")
        return 

    for index in range(len(str)):
        char = str[index]
        if char == "(":
            stacki.append(char)

        elif char == "[":
            stacki.append(char)
        elif char == ")":
            if len(stacki) == 0 or stacki.pop() != "(":
                print("0")
                return

        elif char == "]":
            if len(stacki) == 0 or stacki.pop() != "[":
                print("0")
                return
    if not len(stacki) == 0:
        print("0")
        return
    print("1")
                
isBalanced()
    

