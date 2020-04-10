def solution(n, computers):
    answer = 0
    visited = [0 for i in range(n)]
    while sum(visited) != n :
        start = visited.index(0)
        dfs(visited, computers, start)
        answer += 1
    return answer

def dfs(visited ,computers, start):
    visited[start] = 1
    for i in range(len(visited)):
        if computers[start][i] == 1 and visited[i] == 0:
            dfs(visited, computers, i)
