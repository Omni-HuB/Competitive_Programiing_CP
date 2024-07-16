#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, ans = -1;
vector<vector<int>> g;
vector<int> dp;

int dfs(int idx) {
    if (idx == n) {
        return 1;
    }
    if (dp[idx] != -1)
        return dp[idx];
    int temp = 0;
    for (int i = 0; i < g[idx].size(); i++) {
        temp = max(1 + dfs(g[idx][i]), temp);
    }
    if (temp != 0)
        return dp[idx] = temp;
    else
        return dp[idx] = -1000000;
}

void sol() {
    cin >> n >> m;
    g = vector<vector<int>>(n + 1);
    for (int i = 0; i <= n; i++)
        g[i] = vector<int>();
    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        g[from].push_back(to);
    }
    dp = vector<int>(n + 1, -1);
    ans = dfs(1);
    if (ans > 1)
        cout << ans << endl;
    else
        cout << "IMPOSSIBLE" << endl;
}

int main() {
    int TC = 1;
    for (int i = 0; i < TC; i++) {
        sol();
    }
    return 0;
}
