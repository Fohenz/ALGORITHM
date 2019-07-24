#include <iostream>
using namespace std;

long long dp[91];

long long DP(int N)
{
    if(N < 3)
        return 1;
    if(dp[N])
        return dp[N];
    dp[N] = DP(N-1) + DP(N-2);
    return dp[N];
}

int main()
{
    int N;
    cin >> N;
    cout << DP(N) << endl;
    return 0;
}