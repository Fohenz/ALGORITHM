import copy

def solution(triangle):
    answer = 0
    h = len(triangle)
    results = copy.deepcopy(triangle)
    results[0] = triangle[0]
    
    for i in range(1,h):
        results[i][0] = results[i-1][0] + triangle[i][0]
        results[i][i] = results[i-1][i-1] + triangle[i][i]
        for j in range(1,i):
            results[i][j] = max(results[i-1][j-1], results[i-1][j]) + triangle[i][j]
    
    answer = max(results[h-1])
    return answer
