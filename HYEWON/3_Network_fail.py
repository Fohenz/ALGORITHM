def solution(n, computers):
    answer = 0
    visited = [] #list
    for i in range(n-1):
        if i in visited:
            continue
        def dfs (i):
            nonlocal visited
            for j in range(i):
                if computers[i][j] == 1:  
                    visited.add(i)
                    dfs (j)    
            nonlocal answer
            answer = answer+1
            return;
            
    return answer
