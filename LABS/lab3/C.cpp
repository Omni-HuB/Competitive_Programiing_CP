#include <iostream>
#include <vector>

using namespace std;

vector<int> flipped;
vector<vector<int>> adj;
vector<int> initial;
vector<int> goal;
vector<int> result;

void dfs(int node, int parent) {
    for (int child : adj[node]) {
        if (child != parent) {
            dfs(child, node);
        }
    }

    if (initial[node] != goal[node]) {
        flipped[node] = 1;
        result.push_back(node);

        for (int child : adj[node]) {
            if (child != parent) {
                flipped[child] ^= 1;
            }
        }
    }
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    initial.resize(n + 1);
    goal.resize(n + 1);
    flipped.resize(n + 1, 0);

    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        cin >> initial[i];
    }

    for (int i = 1; i <= n; i++) {
        cin >> goal[i];
    }

    dfs(1, 0);

    cout << result.size() << endl;
    for (int node : result) {
        cout << node << endl;
    }

    return 0;
}
