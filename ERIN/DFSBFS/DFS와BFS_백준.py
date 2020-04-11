def dfs(matrix, path):
  if path[-1] in path[:-1]:
    path.pop()

  if len(matrix) == 0 :
    return path
  
  for m in matrix:
    if path[-1] == m[0]:
      path.append(m[1])
      
    elif path[-1] == m[1]:
      path.append(m[0])
    
    else:
      continue
      
    matrix.remove(m)
    return dfs(matrix, path)
    
def bfs(matrix, path):
  for p in path:
    for i in range(len(matrix)):
      m = matrix[i]
      if p == m[1]:
        path.append(m[0])
      elif p == m[0]:
        path.append(m[1])
      else:
        continue
      if path[-1] in path[:-1]:
        path.pop()
  return path    

N, M, V = map(int, input().split())

matrix = list()
matrix2 = list()
path = [V]
path2 = [V]

for _ in range(M):
   link = list(map(int, input().split()))
   matrix.append(link)
   matrix2.append(link)

matrix.sort()

print(dfs(matrix, path))
print(bfs(matrix2, path2))
