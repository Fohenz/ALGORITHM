def solution(N, number):
    answer = -1
    dp = [set() for i in range(9)]
    
    for i in range(1,9):
        st = ''
        for _ in range(i):
            st += str(N)
        dp[i].add(int(st))
        for j in range(1, i):
            l1 = list(dp[i-j])
            l2 = list(dp[j])
            for n1 in l1:
                for n2 in l2:
                    dp[i].add(n1 + n2)
                    dp[i].add(n1 - n2)
                    dp[i].add(n1 * n2)
                    if n2 != 0:
                        dp[i].add(n1 // n2)
        if number in list(dp[i]):
            answer = i
            break
    return answer
