def solution(N):
    answer = 0
    li = [0 for _ in range(81)]
    li[1], li[2] = 4, 6
    for i in range(3,N+1):
        li[i] = li[i-2] + li[i-1]
    answer = li[N]
    return answer
