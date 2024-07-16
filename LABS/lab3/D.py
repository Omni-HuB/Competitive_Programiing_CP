import heapq

def bidirectional_dijkstra(n, graph, start, target):
    forward_dist = [float('inf')] * (n + 1)
    backward_dist = [float('inf')] * (n + 1)
    forward_dist[start] = 0
    backward_dist[target] = 0

    forward_pq = []
    backward_pq = []
    heapq.heappush(forward_pq, (0, start))
    heapq.heappush(backward_pq, (0, target))

    min_dist = float('inf')

    while forward_pq and backward_pq:
        forward_curr_dist, forward_curr_node = heapq.heappop(forward_pq)

        if forward_curr_dist > min_dist:
            break

        if forward_curr_dist > forward_dist[forward_curr_node]:
            continue

        for neighbor, travel_time in graph[forward_curr_node]:
            total_time = forward_curr_dist + travel_time
            if total_time < forward_dist[neighbor]:
                forward_dist[neighbor] = total_time
                heapq.heappush(forward_pq, (total_time, neighbor))

            # Check if the node is visited from the backward direction
            if backward_dist[neighbor] < float('inf'):
                min_dist = min(min_dist, forward_dist[neighbor] + backward_dist[neighbor])

        backward_curr_dist, backward_curr_node = heapq.heappop(backward_pq)

        if backward_curr_dist > min_dist:
            break

        if backward_curr_dist > backward_dist[backward_curr_node]:
            continue

        for neighbor, travel_time in graph[backward_curr_node]:
            total_time = backward_curr_dist + travel_time
            if total_time < backward_dist[neighbor]:
                backward_dist[neighbor] = total_time
                heapq.heappush(backward_pq, (total_time, neighbor))

            
            if forward_dist[neighbor] < float('inf'):
                min_dist = min(min_dist, forward_dist[neighbor] + backward_dist[neighbor])

    return min_dist if min_dist != float('inf') else -1


n, m, q = map(int, input().split())


graph = [[] for _ in range(n + 1)]
for _ in range(m):
    ni, nj, w = map(int, input().split())
    graph[ni].append((nj, w))
    graph[nj].append((ni, w))


for _ in range(q):
    xi, xj = map(int, input().split())
    min_dist = bidirectional_dijkstra(n, graph, xi, xj)
    print(min_dist)
