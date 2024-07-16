#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

void sol(int source, int n, vector<vector<pair<int, int>>>& graph, vector<vector<int>>& dis) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, source});
    dis[source][source] = 0;

    while (!pq.empty()) {
        int u = pq.top().second;
        int dist = pq.top().first;
        pq.pop();

        if (dist > dis[source][u]) {
            continue;
        }

        for (auto& nbr : graph[u]) {
            int v = nbr.first;
            int weight = nbr.second;

            if (dist + weight < dis[source][v]) {
                dis[source][v] = dist + weight;
                pq.push({dis[source][v], v});
                
            }
        }
    }
}

int main() {
    int n, m, q;
    cin >> n >> m >> q;

    vector<vector<pair<int, int>>> graph(n + 1);
    vector<vector<int>> dis(n + 1, vector<int>(n + 1, INF));

    for (int i = 0; i < m; ++i) {
        int ni, nj, w;
        cin >> ni >> nj >> w;
        graph[ni].push_back({nj, w});
        graph[nj].push_back({ni, w});
    }

    for (int i = 1; i <= n; ++i) {
        sol(i, n, graph, dis);
    }

    while (q--) {
        int xi, xj;
        cin >> xi >> xj;
        int mntrtt = dis[xi][xj];
        if (mntrtt == INF) {
            cout << -1 << endl;
        } else {
            cout << mntrtt << endl;
        }
    }

    return 0;
}
