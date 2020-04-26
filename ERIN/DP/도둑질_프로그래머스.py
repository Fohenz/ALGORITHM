def dp(visited, money, n):
    answer = 0
    for i in range(n, len(money)):
        visited[i] = max(visited[i-1], visited[i-2]+money[i], visited[i-3]+money[i]) 
    #첫번째 집 간 경우, 마지막 집도 갔다면 빼주어야함
    if visited[0] != 0 :
        if visited[-1] == visited[-2]:
            return visited[-1]
        else:
            return visited[-2]
    else:
        return visited[-1]
    
def solution(money):
    answer = 0
    visited = [0 for x in range(len(money))]
    
    answer = max(dp([money[0], money[0], money[0]+money[2] ]+visited[3:], money, 3),  dp([0, money[1], money[1] ]+visited[3:], money, 3), dp([0, 0, money[2] ]+visited[3:], money, 3))
   
    return answer

