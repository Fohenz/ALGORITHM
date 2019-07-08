#include <iostream>
#include <string>
using namespace std;

int C; // 테스트케이스 수 <= 30
int H, W; // 1 <= H: Height, W: Width <= 20
int map[20][20];

int block[4][3][2]= {
    {{0, 0}, {1, 0}, {0, 1}},
    {{0, 0}, {0, 1}, {1, 1}},
    {{0, 0}, {1, 0}, {1, 1}},
    {{0, 0}, {1, 0}, {1, -1}}
    };

bool setCover(int y, int x, int type, int set)
{
    bool ret = true;
    for(int i = 0; i < 3; i++)
    {
        int ny = y + block[type][i][0];
        int nx = x + block[type][i][1];
        if(ny < 0 || ny >= H || nx < 0 || nx >= W)
            ret = false;
        else if((map[ny][nx] += set) > 1)
            ret = false;
    }
    return ret;
}

int cover()
{
    int x = -1, y = -1;
    for(int h = 0; h < H; h++)
    {
        for(int w = 0; w < W; w++)
        {
            if(map[h][w] == 0)
            {
                x = w;
                y = h;
                break;
            } 
        }
        if(y != -1)
            break;
    }

    if(y == -1)
        return 1;
    
    int sum = 0;
    for(int type = 0; type < 4; type++)
    {
        if(setCover(y, x, type, 1))
            sum += cover();
        setCover(y, x, type, -1);
    }
    return sum;
}

int main()
{
    cin >> C;
    for(int i = 0; i < C; i++)
    {
        cin >> H >> W;
        cin.ignore(20, '\n');
        for(int h = 0; h < H; h++)
        {
             string line = "";
             getline(cin, line);

             for (int w = 0; w < line.size(); w++)
             {
                 if (line[w] == '#')
                     map[h][w] = 1;
                 else
                     map[h][w] = 0;
             }
        }
        cout << cover() << endl;
    }   
}