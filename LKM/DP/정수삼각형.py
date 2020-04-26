def solution(triangle):
    answer = 0
    prev = triangle[0]
    for i in range(1,len(triangle)):
        cur = triangle[i]
        path = [0 for _ in range(len(cur))]
        for j in range(len(prev)):
            if prev[j] + cur[j] > path[j]:
                path[j] = prev[j] + cur[j] 
            if prev[j] + cur[j+1] > path[j+1]:
                path[j+1] = prev[j] + cur[j+1]
        prev = path
    answer = max(prev)
    return answer
