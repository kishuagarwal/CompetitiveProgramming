#include <iostream>
#include <cstring>
#include <cstdio>

using namespace std;

int main(void) {
    char c[101];
    char output[300];
    while (scanf("%s", c) != EOF) {
        int length = strlen(c);
        int outputPos = 0;

        int javaFormat = 0;
        int cFormat = 0;
        int error = 0;
        int makeUppercase = 0;

        for (int i = 0; i < length; i++) {
            if (c[i] >= 'a' and c[i] <= 'z') {
                if (makeUppercase) {
                    makeUppercase = 0;
                    output[outputPos++] = 'A' + c[i] - 'a';
                } else
                    output[outputPos++] = c[i];
                continue;
            }
            if (c[i] == '_') {
                if (i != 0 and c[i-1] == '_') {
                    error = 1;
                    break;
                }
                if (javaFormat) {
                    error = 1;
                    break;
                }
                cFormat = 1;
                makeUppercase = 1;
                continue;
            }
            // capital
            if (cFormat) {
                error = 1;
                break;
            }
            javaFormat = 1;
            output[outputPos++] = '_';
            output[outputPos++] = 'a' + c[i] - 'A';
        }
        if (error or c[0] == '_' or c[length-1] == '_' or (c[0] >='A' and c[0] <= 'Z')) {
            cout << "Error!" << endl;
        } else {
            output[outputPos] = '\0';
            cout << output << endl;
        }
    }
    return 0;
}