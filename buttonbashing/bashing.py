from sys import stdin
#Some runtime error - java version works

if __name__ == "__main__":
    testCases = int(stdin.readline())
 
    while testCases > 0:
        nButtons,time = list(map(int,stdin.readline().split()))
        buttons = list(map(int,stdin.readline().split()))
        visited = [False]*3601
        distTo = [0]*3601
        queue:list[int] = []
        queue.insert(0,0) # appends to the end, must be retrieved from the front
        visited[0] = True

        #bfs
        while(queue):
            v = queue.pop()
            for button in buttons:
                w = button+v
                if w <=0: continue
                if w > 3600: w = 3600
                if not visited[w]:
                    visited[w] = True
                    distTo[w] = distTo[v]+1
                    queue.insert(0,w)
            if visited[time]:
                print(str(distTo[time]) + " 0")
                break
        if not visited[time]:
            x = time 
            while not visited[x]:
                x += 1   
            print(str(distTo[x])+ " " + str(x-time))
        testCases -= 1
       

