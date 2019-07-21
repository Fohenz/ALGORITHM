#include <iostream>
using namespace std;

int dp[1001];

int DP(int n)
{
    int ret = 0;

    if(n < 2)
        return 1;
    if(dp[n])
        return dp[n];
    ret = DP(n-1) + DP(n-2);
    dp[n] = ret % 10007;
    return dp[n];
}

int main()
{
    int N;
    cin >> N;
    cout << DP(N) << endl;
    return 0;
}