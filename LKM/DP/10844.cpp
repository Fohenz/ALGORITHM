#include <iostream>
using namespace std;

const int M = 1000000000;
int dp[101][10];

int doSum(int n)
{
    int ret = 0;
    for(int i = 0; i < 10; i++)
        ret = (ret + dp[n][i]) % M;
    return ret;
}

int DP(int n)
{
    int sum = 0;

    if(n < 1)
        return 0;

    sum = doSum(n);
    if(sum)
        return sum;

    for(int i = 2; i <= n; i++)
        for(int j = 0; j < 10; j++)
        {
            if(j == 0)
                dp[i][j] = dp[i-1][j+1];
            else if(j == 9)
                dp[i][j] = dp[i-1][j-1];
            else 
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % M;
        }

    return doSum(n);
}

int main()
{
    for(int i = 1; i < 10; i++)
        dp[1][i] = 1;

    int N;
    cin >> N;
    cout << DP(N) << endl;
    return 0;
}