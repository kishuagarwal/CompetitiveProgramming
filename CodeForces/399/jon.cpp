#include <bits/stdc++.h>
#define rep(i, start, lim) for (int i = start; i < lim; i++)
#define N 100005

using namespace std;
int freq[1100], tmp[1024];
int main() {
    int n,k,x,maxm = 0, minm=INT_MAX,p;
    cin >> n >> k >> x;
    rep(i,0,n) cin >> p,freq[p]++;
    rep(i,0,k) 
    {
        rep(j,0,1024) tmp[j] = freq[j];
        int par = 0;
        rep(j, 0, 1024)
        {
            if (freq[j] > 0)
            {
                int curr = (j ^ x), change = (freq[j]/2);
                if (par == 0)
                {
                    change += (freq[j] & 1);
                }
                tmp[j] -= change;
                tmp[curr] += change;
                par ^= (freq[j]&1);
            }
        }
        rep(j,0,1024) freq[j] = tmp[j];
    }
    rep(i,0,1024) 
    if (freq[i] > 0)
        minm = min(minm, i), maxm = max(maxm, i);
    cout << maxm << " " <<minm;
    return 0;
}