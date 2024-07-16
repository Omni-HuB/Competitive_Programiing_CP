def check_star_tree(N, edges):
    adj_list = [[] for _ in range(N+1)]
    for u, v in edges:
        adj_list[u].append(v)
        adj_list[v].append(u)

    interior_node = -1
    for node in range(1, N+1):
        if len(adj_list[node]) == N-1:
            interior_node = node
        elif len(adj_list[node]) > 1:
            print("NO")
            return

    if interior_node != -1 and len(adj_list[interior_node]) == N-1:
        print("YES")
    else:
        print("NO")

# Read input
N = int(input())
edges = []
for _ in range(N-1):
    u, v = map(int, input().split())
    edges.append((u, v))

# Call the function to check if the tree is a star
check_star_tree(N, edges)
