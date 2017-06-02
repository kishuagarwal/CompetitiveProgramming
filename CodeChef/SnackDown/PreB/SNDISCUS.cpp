#include <iostream>

#define min(a,b) ((a) < (b)) ? (a) : (b)
#define max(a,b) ((a) > (b)) ? (a) : (b)

using namespace std;

int abs(int a) {
    if (a < 0)
        return -a;
    return a;

}

int main(void) {

    int t; 
    cin >> t;
    int s[54][4];
    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;

        int temp;
        for (int j = 0; j < n; j++) {
            cin >> s[j][0] >> s[j][1] >> s[j][2] >> s[j][3];
            if (s[j][0] == s[j][2]) {
                if (s[j][3] < s[j][1]) {
                    temp = s[j][1];
                    s[j][1] = s[j][3];
                    s[j][3] = temp;
                }
            } else {
                if (s[j][2] < s[j][0]) {
                    temp  =s[j][2];
                    s[j][2] = s[j][0];
                    s[j][0] = temp;
                }
            }
        }

        int ans = 100000000;

        for (int x = 1; x <= 50; x++) {
            for (int y = 1; y <= 50; y++) {
                int current = 0;
                for (int j = 0; j < n; j++) {
                    int dist = 0;
                    if (s[j][0] == s[j][2]) {
                        dist += abs(s[j][0] - x);
                        if (s[j][1] > y || s[j][3] < y) {
                            dist += min(abs(s[j][1] - y), abs(s[j][3] -y));
                        }
                    } else {
                        dist += abs(s[j][1] - y);
                        if (s[j][0] > x || s[j][2] < x) {
                            dist += min(abs(s[j][0] - x), abs(s[j][2] - x));
                        }
                    }

                    current = max(current, dist);
                }

                ans = min(ans, current);
            }
        }

        cout << ans << endl;
    }


    return 0;
}