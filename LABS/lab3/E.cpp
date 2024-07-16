// #include <iostream>
// #include <vector>
// #include <queue>
// #include <limits>

// using namespace std;

// const int INF = numeric_limits<int>::max();

// void dijkstra(int n, int m, vector<vector<pair<int, int>>>& graph, vector<vector<int>>& traffic, vector<int>& distances) {
//     priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
//     pq.push({0, 1});
//     distances[1] = 0;

//     while (!pq.empty()) {
//         int curr = pq.top().second;
//         int currTime = pq.top().first;
//         pq.pop();

//         if (curr == n) {
//             break;
//         }

//         if (currTime > distances[curr]) {
//             continue;
//         }

//         // Check if there is a traffic jam at the current intersection and time
//         int currJam = 0;
//         while (currJam < traffic[curr].size() && traffic[curr][currJam] <= currTime) {
//             currJam++;
//         }

//         int nextTime = (currJam < traffic[curr].size()) ? traffic[curr][currJam] : currTime;

//         for (auto& neighbor : graph[curr]) {
//             int next = neighbor.first;
//             int travelTime = neighbor.second;

//             // Check if there is a traffic jam at the next intersection and time
//             int nextJam = 0;
//             while (nextJam < traffic[next].size() && traffic[next][nextJam] <= nextTime + travelTime) {
//                 nextJam++;
//             }

//             int newTime = (nextJam < traffic[next].size()) ? traffic[next][nextJam] : nextTime + travelTime;

//             if (newTime < distances[next]) {
//                 distances[next] = newTime;
//                 pq.push({newTime, next});
//             }
//         }
//     }
// }

// int main() {
//     int n, m;
//     cin >> n >> m;

//     vector<vector<pair<int, int>>> graph(n + 1);
//     vector<vector<int>> traffic(n + 1);
//     vector<int> distances(n + 1, INF);

//     for (int i = 0; i < m; ++i) {
//         int x, y, t;
//         cin >> x >> y >> t;
//         graph[x].push_back({y, t});
//         graph[y].push_back({x, t});
//     }

//     for (int i = 1; i <= n; ++i) {
//         int k;
//         cin >> k;
//         traffic[i].resize(k);
//         for (int j = 0; j < k; ++j) {
//             cin >> traffic[i][j];
//         }
//     }

//     dijkstra(n, m, graph, traffic, distances);

//     if (distances[n] == INF) {
//         cout << -1 << endl;
//     } else {
//         cout << distances[n] << endl;
//     }

//     return 0;
// }

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

const int INF = INT_MAX;

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int, int>>> adj(n + 1);
    vector<vector<int>> times(n + 1);

    for (int i = 0; i < m; i++) {
        int x, y, t;
        cin >> x >> y >> t;
        adj[x].push_back({y, t});
        adj[y].push_back({x, t});
    }

    for (int i = 1; i <= n; i++) {
        int k;
        cin >> k;
        times[i].resize(k);
        for (int j = 0; j < k; j++) {
            cin >> times[i][j];
        }
    }

    vector<int> dist(n + 1, INF);
    dist[1] = 0;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, 1});

    vector<bool> visited(n + 1, false);

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        if (visited[u]) continue;
        visited[u] = true;

        if (u == n) break;

        for (auto& edge : adj[u]) {
            int v = edge.first;
            int t = edge.second;

            int arr_time = dist[u] + t;
            int clear_time = arr_time;

            auto it = upper_bound(times[v].begin(), times[v].end(), arr_time);
            if (it != times[v].end()) {
                clear_time = max(clear_time, *it);
            }

            int new_dist = clear_time + t;

            if (new_dist < dist[v]) {
                dist[v] = new_dist;
                pq.push({dist[v], v});
            }
        }
    }

    if (dist[n] == INF) {
        cout << -1 << endl;
    } else {
        cout << dist[n] << endl;
    }

    return 0;
}
