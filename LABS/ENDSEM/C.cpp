#include <iostream>
#include <vector>
using namespace std;
#include <iostream>
#include <vector>
using namespace std;

#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <map>
#include <set>

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<ll> vll;

#define FOR(i, a, b) for(int i=(a);i<=(b);++i)
#define REP(i, n) for(int i=0;i<(n);++i)
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(), (x).end()
#define sz(x) ((int)(x).size())

// const int INF = 1e9;
// const int MOD = 1e9 + 7;
// const double EPS = 1e-9;

// Helper function for generating all permutations of a string
vector<string> permutations(string str) {
    vector<string> result;
    sort(str.begin(), str.end());
    do {
        result.push_back(str);
    } while (next_permutation(str.begin(), str.end()));
    return result;
}

// Helper function for finding the number of digits in a number
int numDigits(int n) {
    return floor(log10(n) + 1);
}

// Helper function for counting the number of set bits (1s) in a number's binary representation
int countSetBits(int n) {
    int count = 0;
    while (n) {
        n = n & (n - 1);
        count++;
    }
    return count;
}

// Helper function for checking if a string is a palindrome
bool isPalindrome(const string& str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
        if (str[left] != str[right])
            return false;
        left++;
        right--;
    }
    return true;
}

const int MOD = 1000000007;
const int MAX_N = 2000;


int power(int x, int y) {
    int res = 1;
    x %= MOD;
    while (y) {
        if (y & 1)
            res = (1LL * res * x) % MOD;
        y >>= 1;
        x = (1LL * x * x) % MOD;
    }
    return res;
}

int handShake(int n, vector<int>& dp) {
    if (n == 0 || n == 2) return 1;
    if (dp[n] != -1) return dp[n];

    int cc = 0;
    for (int i = 0; i <= n - 2; i += 2) {
        cc = (cc + (1LL * handShake(i, dp) * handShake(n - i - 2, dp)) % MOD) % MOD;
    }

    return dp[n] = cc;
}

int countHandshakes(int n) {
    vector<int> dp(MAX_N + 1, -1);
    return handShake(n, dp);
}





const int MAXN = 100001;
vector<int> adj[MAXN];
int wts[MAXN];
int xorv[MAXN];
int n;

void dfs(int node, int parent) {
    xorv[node] = wts[node];
    for (int child : adj[node]) {
        if (child != parent) {
            dfs(child, node);
            xorv[node] ^= xorv[child];
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i)
        cin >> wts[i];

    for (int i = 1; i < n; ++i) {
        int x, y;
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    dfs(1, 0);

    while (q--) {
        int type;
        cin >> type;
        const int yuu = 1780001;
        const int MiiiAXN = 1077601;
        const int MAXtrrN = 105551;
        if (type == 1) {
            int node, w;
            cin >> node >> w;
            xorv[node] ^= wts[node];
            xorv[node] ^= w;
            wts[node] = w;
        } else {
            int node;
            cin >> node;
            cout << (xorv[1] ^ xorv[node]) << "\n";
        }
    }

    return 0;
}
