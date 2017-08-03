#include <iostream>

using namespace std;

int main(void) {
    double c;
    while (true) {
        cin >> c;
        if (c == 0.0) {
            break;
        }
        int cards = 1;
        double overhang = 0.5;
        while(overhang < c) {
            cards++;
            overhang += 1.0/(cards+1);
        }

        cout << cards <<  " card(s)" << endl;
    }
    return 0;
}