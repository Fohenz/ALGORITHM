import sys
sys.stdin = open("C:/Users/user/Desktop/sample_input.txt", "r")


T, N = map(int, input().split()) #테스트할때 복붙하면 에러나는거 왜 그런거야...
num_list = list(map(int,input().split()))
arr = [[]]*100 #list 다음에 dict로 해보기
arr2 = [[]]*100 #list
visited = 0

def dfs(node): #수정필요
    global visited
    if not arr[node] and not arr2[node]:
        if node == 99:
            visited = 1
        return
    if not arr[node]:
        return
    else:
        dfs(arr[node])
    if not arr2[node]:
        return
    else:
        dfs(arr2[node])

i = 0
while i < len(num_list): #수정필요;;
    arr[num_list[i]] = num_list[i+1]
    j = i+2
    if j > len(num_list)-1:
        break
    if num_list[i] == num_list[j]:
        arr2[num_list[j]] = num_list[j+1]
    else:
        arr[num_list[i]] = num_list[i+1]
    i = i+4

dfs(0)

print('#{} {}'.format(T, visited))
