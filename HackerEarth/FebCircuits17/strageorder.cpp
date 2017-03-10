#include <iostream>
#include <cmath>

using namespace std;

int size = 1000004;
int temp[1000004] = {};
int arr[1000004] = {};
void process(int i) {
    cout << "Currently " << i << endl;
    int s = sqrt(i);
    if (i == 1) {
        cout << 1 << endl;
        return;
    }
    int count = 0;
    for (int j = 2; j <= s; j++) {
        if (i % j == 0) {
            temp[count] = j;
            if (j * j != i)
            temp[size - count - 1] = i/j;
            count++;
        }
    }
    arr[i] = 1;
    cout << i << " " << count << endl;
    for (int i = 0; i < count; i++) {
        if (arr[temp[size-1-i]]) continue;
        arr[temp[size-1-i]] = 1;
        cout << temp[size-1-i] << " ";
    }
    for (int i = count - 1; i >= 0; i--) {
        if (arr[temp[i]]) continue;
        arr[temp[i]] = 1;
        cout << temp[i] << " ";
    }
}

int main()
{
    int n;
    cin >> n;
    
    for (int i = n; i >= 1; i--) {
        if (!arr[i]) {
            process(i);
        }
    }
    return 0;
}
