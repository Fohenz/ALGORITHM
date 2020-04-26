def solution(m, n, puddles):
    answer = 0
    dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
    dp[1][1] = 1
    for x in range(1, m+1):
        for y in range(1, n+1):
            if [x-1, y] not in puddles:
                dp[x][y] += dp[x-1][y] % 1000000007
            if [x, y-1] not in puddles:
                dp[x][y] += dp[x][y-1] % 1000000007
    answer = dp[m][n] % 1000000007
    return answer
