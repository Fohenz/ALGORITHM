#include <iostream>
using namespace std;

int dp[1001][10];

int DP(int N)
{
    for(int i = 0; i <= 9; i++)
        dp[1][i] = 1;
    for(int n = 2; n <= N; n++)
    {
        for(int i = 0; i <= 9; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                dp[n][i] += dp[n-1][j];
                dp[n][i] %= 10007;
            }
        }
    }
    
    int sum = 0;
    for(int i = 0; i <= 9; i++)
        sum += dp[N][i];
    return sum % 1007;
}

int main()
{
    int n;
    cin >> n;
    cout << DP(n) << endl;
    return 0;    
}
