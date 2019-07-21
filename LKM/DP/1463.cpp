#include <iostream>
using namespace std;

int dp[1000001];

int DP(int n)
{
    int ret = 0;

    if(n < 2)
        return 0;
    if(dp[n])
        return dp[n];
    ret = DP(n-1);
    if(n%2 == 0)
    {
        if(ret > DP(n/2))
            ret = DP(n/2);
    }
    if(n%3 == 0)
    {
        if(ret > DP(n/3))
            ret = DP(n/3);
    }
    dp[n] = ret + 1;
    return dp[n];
}

int main()
{
    int N;
    cin >> N;
    cout << DP(N) << endl;
    return 0;
}