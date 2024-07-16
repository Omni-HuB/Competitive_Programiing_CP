import heapq

def solve():
    n, m = map(int, input().split())

    
    adj_list = [[] for _ in range(n+1)]
    for _ in range(m):
        x, y, t = map(int, input().split())
        adj_list[x].append((y, t))
        adj_list[y].append((x, t))

    
    traffic_jams = []
    for _ in range(n):
        jam_times = list(map(int, input().split()))
        traffic_jams.append(jam_times)

    dis = [float('inf')] * (n+1)
    dis[1] = 0

    priority_queue = [(0, 1)] 
    visited = set()

    while priority_queue:
        ctime, cinter = heapq.heappop(priority_queue)

        if cinter in visited:
            continue

        visited.add(cinter)

        if cinter == n:
            return ctime

        if cinter != 1 and ctime in traffic_jams[cinter - 1]:
            ctime += 1

        for nbr, travel_time in adj_list[cinter]:
            new_time = ctime + travel_time
            if new_time < dis[nbr]:
                dis[nbr] = new_time
                heapq.heappush(priority_queue, (new_time, nbr))

    return -1

print(solve())
