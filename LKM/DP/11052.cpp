#include <iostream>
using namespace std;

int dp[1001];
int price[1001];

int DP(int n)
{
    if(n < 1)
        return 0;
    if(dp[n])
        return dp[n];

    int val = 0;
    for(int i = 1; i <= n; i++)
    {
        if(val < DP(n-i) + price[i])
            val = DP(n-i) + price[i];
    }
    dp[n] = val;
    return dp[n];
}

int main()
{
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++)
        cin >> price[i];
    cout << DP(N) << endl;
    return 0;
}