#include <iostream>
#include <deque>

using namespace std;

void bfs(int n, int m, int dist[][504], deque<int> d, int length, int max) {
    int dr[] = {0,-1,-1,-1,0,1,1,1};
    int dc[] = {-1,-1,0,1,1,1,0,-1};
    
    while (length > 0) {
        int r = d[0]; 
        d.pop_front();
        int c = d[0];
        d.pop_front();
        length--;
        for (int i =0 ; i < 8; i++) {
            int cur_r = r + dr[i];
            int cur_c = c + dc[i];
            if (cur_r >= 0 && cur_r < n && cur_c >= 0 && cur_c < m) {
                if (dist[cur_r][cur_c] > dist[r][c] + 1) {
                    dist[cur_r][cur_c] = dist[r][c] + 1;
                    d.push_back(cur_r);
                    d.push_back(cur_c);
                    length++;
                }
            }
        }
    }

}

int main(void) {
    int t;
    cin >> t;
    int a[504][504];
    int dist[504][504];
    for (int i = 0; i < t; i++) {
        int n, m, max = 0;
        cin >> n >> m;
        deque<int> d;
        for (int j = 0;j < n; j++) {
            for (int k = 0; k < m; k++) {
                cin >> a[j][k];
                dist[j][k] = 100000;
                if (a[j][k] > max) {
                    max =a[j][k];
                }
            }
        }
        int length = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (a[j][k] == max ) {
                    d.push_back(j);
                    d.push_back(k);
                    dist[j][k] = 0;
                    length++;
                }
            }
        }
        bfs(n, m, dist, d, length, max);
        max = 0;
        for (int j = 0; j < n; j++) {
            for(int k = 0; k < m ;k++) {
                if (dist[j][k] > max)
                    max= dist[j][k];
            }
        }
        cout << max << endl;
    }
    return 0;
}




