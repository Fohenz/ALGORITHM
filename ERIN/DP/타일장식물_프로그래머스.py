def solution(N):
    answer = 0
    results = [[1, 4] for a in range(81)]
    results[1][1] = 6
    for i in range(2,N):
        results[i][0] = results[i-1][0] + results[i-2][0]
        results[i][1] = results[i-1][1] + results[i][0] * 2
    answer = results[N-1][1]
    return answer
