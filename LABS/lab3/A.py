from collections import defaultdict, deque

def mxloc(n, m, paths):
    graph = defaultdict(list)
    for path in paths:
        x, y = path
        graph[x].append(y)
    
    visited = [False] * (n + 1)
    visited[1] = True
    
    queue = deque()
    queue.append(1)  

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
    
    if visited[n]:
        count = sum(visited)
        return count
    else:
        return "IMPOSSIBLE"


n, m = map(int, input().split())
paths = []
for _ in range(m):
    x, y = map(int, input().split())
    paths.append((x, y))


result = mxloc(n, m, paths)


print(result)

