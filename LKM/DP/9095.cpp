#include <iostream>
using namespace std;

int dp[11];

int DP(int n)
{
    if(n < 0)
        return 0;
    if(n < 2)
        return 1;
    if(dp[n])
        return dp[n];
    dp[n] = DP(n-1) + DP(n-2) + DP(n-3);
    return dp[n];
} 

int main()
{
    int T, N;
    cin >> T;
    while(T--)
    {
        cin >> N;
        cout << DP(N) << '\n';
    }
    return 0;
}