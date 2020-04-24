def solution(m, n, puddles):
    answer = 0
    matrix = [[-1 for x in range(m)] for y in range(n)]
    for p in puddles:
        x, y = p
        matrix[y-1][x-1] = 0
        
    #초기값 세팅
    matrix[0][0] = 1
    for x in range(1,m):
        if matrix[0][x] != 0:
            matrix[0][x] = matrix[0][x-1]
    for x in range(1,n):
        if matrix[x][0] != 0:
            matrix[x][0] = matrix[x-1][0]        
    
    for x in range(1, n):
        for y in range(1, m):
            if matrix[x][y] == 0:
                continue
            upper = matrix[x-1][y]
            left = matrix[x][y-1]
            matrix[x][y] = (upper + left) % 1000000007
            
    answer = matrix[-1][-1]
    return answer
